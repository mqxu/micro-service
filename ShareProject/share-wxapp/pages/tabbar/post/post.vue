<template>
	<view class="container">
		<!-- 标题卡片模式 -->
		<uni-card title="微服务技术" mode="title" :is-shadow="true" thumbnail="https://img-cdn-qiniu.dcloud.net.cn/uniapp/images/muwu.jpg" extra="技术没有上限" note="软件_1851">
			微服务技术微服务技术
		</uni-card>
		<button @click="contribute">投稿</button>
	</view>
</template>
<script>
import { request, get } from '@/utils/request';
import { CONTRIBUTE_URL } from '@/utils/api';
export default {
	data() {
		return {
			title: '投稿'
		};
	},
	methods: {
		contribute() {
			uni.showToast({
				title: '投稿'
			});
			request(CONTRIBUTE_URL, 'POST', {
				author: '陶然然',
				downloadUrl: 'www.baidu.com',
				isOriginal: 'true',
				price: 29,
				summary: '一个资源',
				title: '一个资源'
			}).then(res => {
				console.log(res);
			});
		}
	}
};
</script>
<style></style>
