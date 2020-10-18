<template>
	<view class="container">
		<h4 class="title">{{ share.title }}</h4>
		<image :src="share.cover"></image>
		<p>{{ share.summary }}</p>
		<p>{{ share.downloadUrl }}</p>
		<button @click="paste">复制下载地址</button>
	</view>
</template>

<script>
import { request } from '@/utils/request';
import { SHARE_URL } from '@/utils/api';
export default {
	data() {
		return {
			share: null,
			id: ''
		};
	},
	onLoad(option) {
		this.id = option.id;
		console.log(this.id);
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
			console.log(res.data);
			this.share = res.data.share;
		},
		paste() {
			uni.setClipboardData({
				data: this.share.downloadUrl,
				success: function() {
					uni.showToast({
						title: '下载地址已复制'
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
}
.title {
	font-size: 16px;
	font-weight: 500;
	margin-bottom: 20px;
}
p {
	margin: 10px;
}
</style>
