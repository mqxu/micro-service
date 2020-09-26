<template>
	<cu-custom bgColor="bg-gradual-red" :isBack="false">
		<!-- <block slot="backText">返回</block> -->
	    <block slot="content">我的</block>
	</cu-custom>
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
