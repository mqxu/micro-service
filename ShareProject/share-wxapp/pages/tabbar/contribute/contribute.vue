<template>
	<view>
		<view class="description">说明：投稿审核通过后会有积分奖励；资源被下载会有积分奖励；提交的资源不得包含广告、侵权信息，百度盘地址建议有密码。</view>
		<view class="uni-list">
			<radio-group @change="radioChange">
				<label class="uni-list-cell uni-list-cell-pd" v-for="(item, index) in items" :key="item.value">
					<view class="align-between">
						<text>{{ item.name }}</text>
						<radio :value="item.value" :checked="index === current" />
					</view>
				</label>
			</radio-group>
			<view class="align">
				<text>标题</text>
				<input class="uni-input" focus placeholder="请输入标题" v-model="title" />
			</view>
			<view class="align">
				<text>作者</text>
				<input class="uni-input" placeholder="请输入作者" v-model="author" />
			</view>
			<view class="align">
				<text>价格</text>
				<input class="uni-input" type="number" placeholder="请输入价格" v-model="price" />
			</view>
			<view class="align">
				<text>简介</text>
				<input class="uni-input" placeholder="介绍一下技术干货吧" v-model="summary" />
			</view>
			<view class="align">
				<text>封面图</text>
				<input class="uni-input" placeholder="请输入封面图地址" v-model="cover" />
			</view>
			<view class="align">
				<text>下载地址</text>
				<input class="uni-input" placeholder="请输入下载地址" v-model="downloadUrl" />
			</view>
			<view><button class="submit" @click="submit">提交</button></view>
		</view>
	</view>
</template>
<script>
import { request } from '@/utils/request';
import { CONTRIBUTE_URL } from '@/utils/api';
export default {
	data() {
		return {
			items: [
				{
					value: 'yc',
					name: '原创',
					checked: 'true'
				},
				{
					value: 'zz',
					name: '转载'
				}
			],
			current: 0,
			isOriginal: true,
			title: '',
			author: '',
			price: '',
			cover: 'https://img2.sycdn.imooc.com/szimg/5b3082da0001d7e905400300-360-202.jpg',
			summary: '',
			downloadUrl: '链接: https://pan.baidu.com/s/1Hk9i9VOTz2eSuy8p-kFGrQ  密码: 5njn'
		};
	},
	methods: {
		radioChange: function(evt) {
			for (let i = 0; i < this.items.length; i++) {
				if (this.items[i].value === evt.target.value) {
					this.current = i;
					console.log(this.current);
					this.isOriginal = this.current === 0 ? true : false;
					console.log(this.isOriginal);
					break;
				}
			}
		},
		async submit() {
			uni.showLoading({
				title: '投稿中'
			});
			let res = await request(CONTRIBUTE_URL, 'POST', {
				isOriginal: this.isOriginal,
				title: this.title,
				author: this.author,
				price: this.price,
				cover: this.cover,
				summary: this.summary,
				downloadUrl: this.downloadUrl
			});
			setTimeout(() => {
				uni.hideLoading();
			}, 100);
			if (res.succ == true) {
				let self = this;
				uni.showModal({
					title: '提示',
					content: '投稿成功，将在最短时间内审核资源！',
					cancelText: '返回首页',
					confirmText: '继续投稿',
					success(res) {
						if (res.confirm) {
							self.isOriginal = false;
							self.title = '';
							self.author = '';
							self.price = '';
							self.summary = '';
							self.downloadUrl = '';
						} else {
							uni.switchTab({
								url: '../home/home'
							});
						}
					}
				});
			}
		}
	}
};
</script>
<style lang="scss" scoped>
.description {
	padding: 15px 15px;
}
.align-between {
	display: flex;
	justify-content: space-between;
	padding: 15px 15px;
	border-bottom: 1px solid #eee;
}
.align {
	display: flex;
	justify-content: start;
	padding: 15px 15px;
	border-bottom: 1px solid #eee;
	text {
		flex: 0 0 25%;
	}
}
.submit {
	background-color: #ec544d;
	color: #fff;
}
</style>
