<template>
	<view class="my-card" @click="onClick">
		<view class="thumb">
			<image :src="share.cover" class="img" mode="aspectFill" />
			<text class="tag origin" v-if="share.isOriginal">原创</text>
			<text v-else class="tag reprint">转载</text>
		</view>
		<view class="detail">
			<view class="mid">
				<view class="title">{{ share.title }}</view>
				<view class="summary">{{ share.summary.length > 30 ? share.summary.substring(0, 30) : share.summary }}</view>
			</view>
			<view class="right">
				<view>{{ share.price }}积分</view>
				<view class="right" v-if="share.downloadUrl">下载</view>
				<view class="right" v-else>兑换</view>
			</view>
		</view>
	</view>
</template>
<script>
export default {
	name: 'MyCard',
	props: ['share'],
	// computed: {
	// 	summary() {
	// 		let summary = this.share.summary;
	// 		if (summary && summary.length > 30) {
	// 			summary = summary.substring(0, 30) + '...';
	// 		}
	// 		return summary;
	// 	}
	// },
	methods: {
		onClick() {
			this.$emit('click');
		}
	}
};
</script>
<style lang="scss" scoped>
.my-card {
	padding: 15px 15px;
	border-bottom: 1px dashed #ddd;
	display: flex;
	background-color: #fff;
	font-size: 14px;
	.thumb {
		width: 90px;
		height: 90px;
		position: relative;
		.img {
			width: 70px;
			height: 70px;
			border-radius: 50%;
			position: absolute;
			top: 5px;
			left: 5px;
		}
		.tag {
			color: #fff;
			padding: 2px 2px;
			position: absolute;
			top: 0;
			left: 0;
		}
		.origin {
			background-color: #ff4444;
		}
		.reprint {
			background-color: #3ebd00;
		}
	}
	.detail {
		padding-left: 20px;
		word-wrap: break-word;
		width: 100%;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		.mid {
			.title {
				font-weight: bold;
			}
		}
		.right {
			width: 70px;
			text-align: right;
		}
	}
}
</style>
