<template>
	<view class="content">
		{{title}}
	</view>
</template>

<script>
export default {
	data() {
		return {
			title: '我的'
		};
	},
	onLoad() {},
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
