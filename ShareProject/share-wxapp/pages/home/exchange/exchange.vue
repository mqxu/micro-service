<template>
	<view class="container">
		<h4>{{ share.title }}</h4>
		<p>
			<span>作者：{{ share.author }}</span>
			<span>发布人：{{ wxNickname }}</span>
			<span>下载次数：{{ share.buyCount }}</span>
		</p>
		<image :src="share.cover"></image>
		<p>{{ share.summary }}</p>
		<view class="exchange">
			<p>
				¥积分
				<span class="price">{{ share.price }}</span>
			</p>
			<button class="btn" @click="exchange">兑换</button>
		</view>
	</view>
</template>

<script>
import { get, request } from '@/utils/request';
import { SHARE_URL, EXCHANGE_URL, USER_URL } from '@/utils/api';
export default {
	data() {
		return {
			share: null,
			wxNickname: ''
		};
	},
	onLoad(option) {
		let id = option.id;
		this.getShare(id);
	},
	methods: {
		async getShare(id) {
			let res = await get(SHARE_URL + '/' + id);
			console.log(res.data);
			this.share = res.data.share;
			this.wxNickname = res.data.wxNickname;
		},
		exchange() {
			// console.log('资源id：' + this.share.id);
			// console.log('用户id：' + uni.getStorageSync('user').id);
			request(EXCHANGE_URL, 'POST', {
				userId: uni.getStorageSync('user').id,
				shareId: this.share.id
			}).then(res => {
				console.log(JSON.stringify(res) + '>>>>>>>>>>>>>');
				if (res.succ === true) {
					uni.showToast({
						title: '兑换成功',
						duration: 2000
					});
					//重新请求用户数据
					get(USER_URL + '/' + uni.getStorageSync('user').id).then(res => {
						//移除原有用户缓存数据，存入新的数据
						uni.removeStorageSync('user');
						uni.setStorageSync('user', res.data);
						//跳回首页
						uni.switchTab({
							url: '/pages/tabbar/home/home'
						});
					});
				}
			});
		}
	}
};
</script>

<style>
.container {
	padding: 10px;
	font-size: 15px;
	background-color: #ffffff;
}
h4 {
	font-size: 16px;
	font-weight: 500;
	margin-bottom: 20px;
}
.exchange {
	position: fixed;
	bottom: 10px;
	right: 10px;
	display: flex;
	justify-content: end;
	align-items: center;
}
p {
	margin: 10px;
}
p span {
	margin-right: 15px;
}
.btn {
	background-color: #ec544d;
	max-height: 35px;
	min-width: 85px;
	color: #ffffff;
	margin-left: 10px;
	font-size: 14px;
}
.price {
	color: #ec544d;
}
</style>
