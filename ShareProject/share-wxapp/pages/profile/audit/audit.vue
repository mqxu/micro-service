<template>
	<view>
		<uni-list>
			<uni-list-item
				v-for="(share, index) in shares"
				:title="share.title"
				:thumb="share.cover"
				:note="share.summary"
				rightText="去审核"
				@click="auditDetail(share.id)"
				:key="index"
			></uni-list-item>
		</uni-list>
	</view>
</template>

<script>
import { request } from '@/utils/request';
import { NOT_YET_SHARE_URL } from '@/utils/api';
export default {
	data() {
		return {
			shares: []
		};
	},
	onLoad() {
		//console.log(uni.getStorageSync('user'));
		uni.showLoading({
			title: '加载中'
		});
		this.getShares();
	},
	onPullDownRefresh() {
		this.getShares();
	},
	methods: {
		async getShares() {
			let res = await request(NOT_YET_SHARE_URL, 'GET', {});
			console.log(res);
			setTimeout(() => {
				uni.hideLoading();
			}, 100);
			if (res.succ == true) {
				this.shares = res.data;
				uni.stopPullDownRefresh();
			} else {
				uni.showToast({
					title: '没有权限访问'
				});
			}
		},
		auditDetail(id) {
			uni.navigateTo({
				url: `../audit-detail/audit-detail?id=${id}`
			});
		}
	}
};
</script>

<style lang="scss"></style>
