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
import { get } from '@/utils/request';
import { SHARE_URL } from '@/utils/api';
export default {
	data() {
		return {
			share: null
		};
	},
	onLoad(option) {
		let id = option.id;
		console.log(id);
		this.getShare(id);
	},
	methods: {
		async getShare(id) {
			let res = await get(SHARE_URL + '/' + id);
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
