<template>
	<view>
		<view v-if="!user" class="no-login">
			<image src="../../../static/unlogin.png" class="avatar" />
			<text class="info">登录，享受技术之旅吧！</text>
			<button open-type="getUserInfo" @getuserinfo="bindGetUserInfo" @click="appLogin">微信账号登录</button>
		</view>
		<view v-else>
			<view class="header">
				<img :src="user.avatarUrl" class="avatar" />
				<span class="span">{{ user.wxNickname }}</span>
				<span class="span">积分:{{ user.bonus }}</span>
				<view class="span">
					<button size="mini" type="primary" @click="sign">签到</button>
					<button size="mini" type="primary" @click="logout">退出</button>
				</view>
			</view>
			<uni-list>
				<uni-list-item title="我的兑换" showArrow="true" is-link @click="myExchange"></uni-list-item>
				<uni-list-item title="积分明细" showArrow="true" is-link @click="myBonusLog"></uni-list-item>
				<uni-list-item title="我的投稿" showArrow="true" is-link @click="myContribute"></uni-list-item>
				<uni-list-item title="审核投稿" showArrow="true" is-link @click="audit" v-if="user.roles === 'admin'"></uni-list-item>
				<!-- <uni-list-item title="审核投稿" showArrow="true" is-link @click="audit"></uni-list-item> -->
			</uni-list>
		</view>
	</view>
</template>

<script>
import { formatTime } from '@/utils/index';
import { request } from '@/utils/request';
import { LOGIN_URL, USER_URL } from '@/utils/api';
export default {
	data() {
		return {
			user: null
		};
	},
	onLoad() {
		if (uni.getStorageSync('user')) {
			this.user = uni.getStorageSync('user');
		}
	},
	onShow() {
		if (uni.getStorageSync('user')) {
			this.getUser();
		}
	},
	// onShow() {
	// if (uni.getStorageSync('user')) {
	// 	this.user = uni.getStorageSync('user');
	// }
	// let token = uni.getStorageSync('token');
	// console.log('token有效期到：' + formatTime(new Date(token.expirationTime)));
	// // 如果token存在，并且token没过期
	// if (token && token.expirationTime - new Date().getTime() > 0) {
	// 	this.getUser();
	// }
	// // token不存在，或者token过期，直接清理storage
	// else {
	// 	uni.clearStorageSync();
	// 	this.user = null;
	// }
	// let token = uni.getStorageSync('token');
	// if (token) {
	// 	this.getUser();
	// }
	// },
	methods: {
		bindGetUserInfo(e) {
			let platform = uni.getSystemInfoSync().platform;
			//此处e.mp事件适用于mini program小程序
			if (e.mp.detail.rawData) {
				//用户按了允许授权按钮
				this.wxLogin(e);
			} else {
				//用户按了拒绝按钮
				uni.showToast({
					title: '授权失败'
				});
			}
		},
		wxLogin(e) {
			let self = this;
			let userInfo = e.mp.detail.userInfo;
			wx.login({
				success(res) {
					// console.log(res);
					if (res.errMsg === 'login:ok') {
						let loginDTO = {
							loginCode: res.code,
							wxNickname: userInfo.nickName,
							avatarUrl: userInfo.avatarUrl
						};
						//统一调用登录方法
						self.userLogin(loginDTO);
					} else {
						console.log('登录失败！' + res.errMsg);
					}
				}
			});
		},
		appLogin() {
			let self = this;
			uni.login({
				provider: 'weixin',
				success: function(loginRes) {
					uni.getUserInfo({
						provider: 'weixin',
						success: infoRes => {
							//统一的登录请求参数
							let loginDTO = {
								openId: infoRes.userInfo.openId,
								wxNickname: infoRes.userInfo.nickName,
								avatarUrl: infoRes.userInfo.avatarUrl
							};
							//统一调用登录方法
							self.userLogin(loginDTO);
						}
					});
				}
			});
		},
		async userLogin(loginDTO) {
			uni.showLoading({
				title: '登录中'
			});
			const res = await request(LOGIN_URL, 'POST', loginDTO);
			setTimeout(() => {
				uni.hideLoading();
			}, 1000);
			console.log(res.data);
			if (res.succ === true) {
				uni.showToast({
					title: '登录成功'
				});
				this.user = res.data.user;
				uni.setStorageSync('user', res.data.user);
				uni.setStorageSync('token', res.data.token);
			}
		},
		async getUser() {
			let id = uni.getStorageSync('user').id;
			await request(USER_URL + `/${id}`, 'GET', {}).then(res => {
				console.log(JSON.stringify(res.data) + '>>>>>>>>>>>>>>>>>');
				uni.setStorageSync('user', res.data);
				this.user = res.data;
			});
		},
		sign() {
			// console.log(uni.getStorageSync('user'));
		},
		logout() {
			this.user = null;
			uni.clearStorageSync();
		},
		myExchange() {
			uni.navigateTo({
				url: '../../profile/my-exchange/my-exchange'
			});
		},
		myBonusLog() {
			uni.navigateTo({
				url: '../../profile/my-bonus-log/my-bonus-log'
			});
		},
		myContribute() {
			uni.navigateTo({
				url: '../../profile/my-contribute/my-contribute'
			});
		},
		audit() {
			uni.navigateTo({
				url: '../../profile/audit/audit'
			});
		}
	}
};
</script>

<style lang="scss">
.header {
	margin-top: 20px;
	display: flex;
	flex-direction: column;
	align-items: center;
	font-size: 16px;
	background-color: white;
	margin-bottom: 30px;
	.avatar {
		width: 100px;
		height: 100px;
		border-radius: 50%;
		margin-top: 15px;
	}
	.span {
		margin-top: 10px;
		button {
			margin: 10px;
		}
	}
}
.no-login {
	margin-top: 20px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	.avatar {
		width: 150px;
		height: 150px;
		border-radius: 50%;
	}
	.info {
		font-size: 16px;
		margin-top: 20px;
		margin-bottom: 30px;
	}
	button {
		background-color: #ec544d;
		color: #ffffff;
	}
}
</style>
