<template>
	<view class="content">
		{{title}}
	</view>
</template>

<script>
export default {
	data() {
		return {
			title: 'uniapp H5首页,我就准备抄抄学生的作业'
		};
	},
	onLoad() {
		uni.request({
		    url: 'https://www.example.com/request', //仅为示例，并非真实接口地址。
		    data: {
		        text: 'uni.request'
		    },
		    header: {
		        'custom-header': 'hello' //自定义请求头信息
		    },
		    success: (res) => {
		        console.log(res.data);
		        this.text = 'request success';
		    }
		});
	},
	methods: {}
};
</script>

<style>
.content {
	text-align: center;
	height: 400upx;
	margin-top: 200upx;
}
</style>
