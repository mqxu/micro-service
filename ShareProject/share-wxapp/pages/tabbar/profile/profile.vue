<template>
	<view class="container">
		<view v-if="!user" class="box">
			<image src="https://i.loli.net/2020/10/10/mFxrTZNwPG6CBta.png" class="avatar" />
			<text class="info">登录，享受技术之旅吧！</text>
			<button open-type="getUserInfo" @getuserinfo="bindGetUserInfo" @click="appLogin">微信账号登录</button>
		</view>
		<view v-else>
			<view class="center">
				<view><image :src="user.avatarUrl" class="avatar" /></view>
				<!-- <button @click="logout" class="logout">退出</button> -->
				<view>
					<view class="line">
						<text>{{ user.wxNickname }}</text>
					</view>
					<view class="line">
						<text>当前积分：{{ user.bonus }}</text>
					</view>
				</view>
				<view><button class="sign" @click="sign">签到</button></view>
			</view>

			<p class="item">我的兑换</p>
			<p class="item">积分明细</p>
			<p class="item">我的投稿</p>
		</view>
	</view>
</template>

<script>
import { request, get } from '@/utils/request';
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
			this.user = uni.getStorageSync('user');
		}
	},
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
			// console.log(userInfo);
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
		userLogin(loginDTO) {
			console.log(loginDTO);
			request(LOGIN_URL, 'POST', loginDTO).then(res => {
				if (res.succ === true) {
					uni.showToast({
						title: '登录成功'
					});
				}
				console.log(res);
				this.user = res.data.user;
				uni.setStorageSync('user', res.data.user);
				uni.setStorageSync('token', res.data.token);
			});
		},
		sign() {
			console.log(uni.getStorageSync('user'));
		},
		logout() {
			this.user = null;
			uni.clearStorageSync();
		}
	}
};
</script>

<style lang="scss">
.container {
	padding-top: 40px;
	text-align: center;
	.box {
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
	.center {
		display: flex;
		flex-direction: column;
		align-items: center;
		.avatar {
			width: 120px;
			height: 120px;
			border-radius: 50%;
		}
		.line {
			margin-top: 10px;
			margin-bottom: 10px;
		}
		.sign {
			width: 100px;
			height: 35px;
			background-color: #4c9d44;
			color: #ffffff;
			margin: 20px;
			font-size: 15px;
		}
	}
}
.item {
	text-align: left;
	padding-left: 30px;
	line-height: 50px;
	border-bottom: 1px dashed #ddd;
}
</style>
