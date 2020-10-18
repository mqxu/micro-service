<template>
	<view>
		<view v-for="(share, index) in shares" :key="index"><my-card :share="share" :key="index" @click="gotoDetail(share.id)"></my-card></view>
	</view>
</template>

<script>
import myCard from '@/components/my-card/my-card.vue';
import { request } from '@/utils/request';
import { MY_EXCHANGE_URL } from '@/utils/api';
export default {
	data() {
		return {
			shares: [],
			pageNo: 1,
			pageSize: 7,
			more: true
		};
	},
	onLoad() {
		this.getShares(true);
	},
	onReachBottom() {
		if (!this.more) {
			uni.showToast({
				title: '已加载完毕',
				duration: 1000
			});
			return false;
		}
		this.pageNo = this.pageNo + 1;
		uni.showLoading({
			title: '加载中'
		});
		this.getShares();
		setTimeout(() => {
			uni.hideLoading();
		}, 1000);
	},
	onPullDownRefresh() {
		this.getShares(true);
	},
	methods: {
		async getShares(init) {
			if (init) {
				this.pageNo = 1;
				this.more = true;
			}
			uni.showLoading({
				title: '加载中'
			});
			let res = await request(MY_EXCHANGE_URL, 'GET', {
				pageNo: this.pageNo,
				pageSize: this.pageSize
			});
			setTimeout(() => {
				uni.hideLoading();
			}, 100);
			if (init) {
				this.shares = res.data;
				uni.stopPullDownRefresh();
			} else {
				this.shares = this.shares.concat(res.data);
			}
			if (res.data.length < this.pageSize && this.pageNo > 0) {
				this.more = false;
			}
		},
		gotoDetail(id) {
			uni.navigateTo({
				url: `../../home/share-detail/share-detail?id=${id}`
			});
		}
	}
};
</script>

<style lang="scss"></style>
