<template>
	<view class="container">
		<view>
			<uni-segmented-control :current="current" :values="menus" @clickItem="onClickItem" style-type="text" active-color="#EC544D"></uni-segmented-control>
			<view class="content">
				<view v-if="current === 0">
					<p class="notice">{{ notice.content }}</p>
					<uni-search-bar></uni-search-bar>
					<uni-list>
						<uni-list-item
							:title="item.title"
							:note="item.summary"
							:thumb="item.cover"
							thumb-size="lg"
							:showBadge="item.price + '积分'"
							:rightText="item.downloadUrl === null ? '兑换' : '下载'"
							showArrow="false"
							v-for="(item, index) in items"
							:key="index"
							class="item"
						/>
					</uni-list>
				</view>
				<view v-if="current === 1">
					<uni-card
						title="微服务技术"
						mode="title"
						:is-shadow="true"
						thumbnail="https://img-cdn-qiniu.dcloud.net.cn/uniapp/images/muwu.jpg"
						extra="技术没有上限"
						note="软件_1851"
					>
						使用说明
					</uni-card>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
import uniSegmentedControl from '@/components/uni-segmented-control/uni-segmented-control.vue';
import uniSearchBar from '@/components/uni-search-bar/uni-search-bar.vue';
import { request, get } from '@/utils/request';
import { SHARE_LIST_URL, NOTICE_URL } from '@/utils/api';
export default {
	components: { uniSegmentedControl, uniSearchBar },
	data() {
		return {
			menus: ['发现', '使用说明'],
			current: 0,
			items: [],
			notice: {}
		};
	},
	onLoad() {
		this.getShares();
		this.getNotice();
	},
	onShow() {
		this.getShares();
	},
	methods: {
		onClickItem(e) {
			if (this.current !== e.currentIndex) {
				this.current = e.currentIndex;
			}
		},
		async getShares() {
			//shares列表
			let res = await get(SHARE_LIST_URL);
			this.items = res.data;
			// console.log(this.items);
		},
		async getNotice() {
			//公告
			let notice = await get(NOTICE_URL);
			// console.log(notice.data);
			this.notice = notice.data;
		}
	}
};
</script>

<style>
.container {
	padding: 10px;
	line-height: 24px;
}
.item {
	font-size: 20px;
}
.notice {
	margin-top: 10px;
	font-size: 16px;
	color: #ec544d;
}
</style>
