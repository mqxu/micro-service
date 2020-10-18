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
import { request } from '@/utils/request';
import { SHARE_URL, EXCHANGE_URL, USER_URL } from '@/utils/api';
export default {
	data() {
		return {
			id: '',
			share: '',
			wxNickname: '',
			userId: ''
		};
	},
	onLoad(option) {
		this.id = option.id;
		this.userId = uni.getStorageSync('user').id;
		this.getShare();
	},
	methods: {
		async getShare() {
			let id = this.id;
			uni.showLoading({
				title: '加载中'
			});
			let res = await request(SHARE_URL + `/${id}`, 'GET', {});
			setTimeout(() => {
				uni.hideLoading();
			}, 100);
			// console.log(res.data);
			this.share = res.data.share;
			this.wxNickname = res.data.wxNickname;
		},
		async exchange() {
			let self = this;
			console.log(self.userId + '>>>>>>>>>>>');
			await request(EXCHANGE_URL, 'POST', {
				userId: self.userId,
				shareId: self.share.id
			}).then(res => {
				uni.showModal({
					title: '兑换成功',
					content: '确定去查看，取消继续兑换',
					success: function(res) {
						if (res.confirm) {
							uni.redirectTo({
								url: `/pages/home/share-detail/share-detail?id=${self.id}`
							});
						} else if (res.cancel) {
							uni.switchTab({
								url: '../../tabbar/home/home'
							});
						}
					}
				});
				// request(USER_URL + '/' + self.userId, 'GET', {}).then(res1 => {
				// 	console.log(res1);
				// 	//移除原有用户缓存数据，存入新的数据
				// 	uni.removeStorageSync('user');
				// 	uni.setStorageSync('user', res1.data);
					
				// });
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
