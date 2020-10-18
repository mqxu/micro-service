<template>
	<view class="container">
		<h4 class="title">{{ share.title }}</h4>
		<view class="share-info">
			<text>作者：{{ share.author }}</text>
			<text>发布人：{{ wxNickname }}</text>
			<text>积分：{{ share.price }}</text>
			<text>来源：{{ share.isOriginal === true ? '原创' : '转载' }}</text>
		</view>
		<image :src="share.cover"></image>
		<p>{{ share.summary }}</p>
		<p>{{ share.downloadUrl }}</p>
		<view class="audit-area">
			<view class="uni-list">
				<view class="uni-list-cell uni-list-cell-pd">
					<span class="uni-list-cell-db">{{ tip1 }}</span>
					<switch checked @change="switch1Change" />
				</view>
				<!-- 选择不通过审核才出现这个编辑框 -->
				<view v-if="flag1 === false"><input class="reason-input" focus placeholder="请输入拒审原因" v-model="reason" /></view>
				<view class="uni-list-cell uni-list-cell-pd">
					<span class="uni-list-cell-db">{{ tip2 }}</span>
					<switch checked @change="switch2Change" />
				</view>
			</view>
			<button @click="submit" class="submit">提交</button>
		</view>
	</view>
</template>

<script>
import { request } from '@/utils/request';
import { SHARE_URL, AUDIT_URL } from '@/utils/api';
export default {
	data() {
		return {
			share: null,
			wxNickname: '',
			id: '',
			flag1: true,
			flag2: true,
			reason: '',
			tip1: '通过审核',
			tip2: '立刻发布'
		};
	},
	onLoad(option) {
		this.id = option.id;
		console.log(this.id);
		this.getShare();
	},
	methods: {
		switch1Change: function(e) {
			this.flag1 = e.target.value;
			e.target.value === true ? (this.tip1 = '通过审核') : (this.tip1 = '拒绝通过');
		},
		switch2Change: function(e) {
			this.flag2 = e.target.value;
			e.target.value === true ? (this.tip2 = '立刻发布') : (this.tip2 = '暂不发布');
		},
		async getShare() {
			let id = this.id;
			uni.showLoading({
				title: '加载中'
			});
			let res = await request(SHARE_URL + `/${id}`, 'GET', {});
			setTimeout(() => {
				uni.hideLoading();
			}, 100);
			console.log(res.data);
			this.share = res.data.share;
			this.wxNickname = res.data.wxNickname;
		},
		async submit() {
			uni.showLoading({
				title: '审核中'
			});
			let res = await request(AUDIT_URL + `/${this.share.id}`, 'PUT', {
				auditStatusEnum: this.flag1 === true ? 'PASS' : 'REJECT',
				reason: this.flag1 === true ? '通过审核' : this.reason,
				showFlag: this.flag2
			});
			setTimeout(() => {
				uni.hideLoading();
			}, 100);
			console.log(res);
			if (res.succ == true) {
				uni.showToast({
					title: '审核成功'
				});
				uni.redirectTo({
					url: '../audit/audit'
				});
			}
		}
	}
};
</script>

<style lang="scss" scoped>
.container {
	padding: 10px;
	font-size: 15px;
	.title {
		font-size: 16px;
		font-weight: 500;
		margin-bottom: 20px;
	}
	.share-info {
		display: flex;
		justify-content: space-around;
		margin-bottom: 10px;
	}
	p {
		margin: 10px;
	}
	.audit-area {
		border-top: 1px solid #ccc;
		.uni-list-cell-pd {
			display: flex;
			justify-content: space-between;
			margin: 5px 5px;
			padding: 10px 10px;
		}
		.submit {
			background-color: #ec544d;
			color: #fff;
		}
	}
}

.reason-input {
	font-size: 15px;
	margin: 10px 10px;
	min-height: 30px;
	border: 1px dashed #ccc;
}
</style>
