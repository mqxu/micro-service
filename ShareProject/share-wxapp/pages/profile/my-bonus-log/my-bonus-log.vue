<template>
	<view>
		<uni-list>
			<uni-list-item
				v-for="(bonusLog, index) in bonusLogs"
				:key="index"
				showExtraIcon="true"
				:extraIcon="bonusLog.icon"
				:title="bonusLog.createTime + '--' + bonusLog.title + ' ' + bonusLog.value"
			></uni-list-item>
		</uni-list>
	</view>
</template>

<script>
import { request } from '@/utils/request';
import { MY_BONUS_LOG_URL } from '@/utils/api';
export default {
	data() {
		return {
			bonusLogs: []
		};
	},
	onLoad() {
		this.fetchBonusLogs();
	},
	onShow() {},
	methods: {
		async fetchBonusLogs() {
			uni.showLoading({
				title: '加载中'
			});
			//请求积分明细数据，并用js数组的map进行过滤，根据积分事件搭配不同的图标
			let res = await request(MY_BONUS_LOG_URL, 'GET', {});

			let bonusLogs = res.data;
			this.bonusLogs = bonusLogs.map(function(item) {
				let res = {};
				switch (item.event) {
					case 'BUY':
						res.icon = { color: '#aaa', size: '20', type: 'download' };
						res.title = '兑换';
						break;
					case 'SIGN':
						res.icon = { color: '#aaa', size: '20', type: 'person' };
						res.title = '签到';
						break;
					case 'CONTRIBUTE':
						res.icon = { color: '#aaa', size: '20', type: 'compose' };
						res.title = '投稿';
						break;
					case 'FORWARD':
						res.icon = { color: '#aaa', size: '20', type: 'redo' };
						res.title = '转发';
						break;
				}
				res.value = item.value;
				res.createTime = item.createTime;
				res.description = item.description;
				// let description = item.description;
				// if (description && description.length > 20) {
				// 	res.description = description.substring(0, 20) + '...';
				// }
				// console.log(res);
				setTimeout(() => {
					uni.hideLoading();
				}, 100);
				return res;
			});
		}
	}
};
</script>

<style lang="scss"></style>
