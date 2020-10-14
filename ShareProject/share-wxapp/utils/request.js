/**
 * 封装uniapp的request
 */
export function request(url, method, data) {
	let token = ''
	// console.log(typeof(uni.getStorageSync('token').token))
	if (typeof(uni.getStorageSync('token').token) == 'undefined') {
		token = 'no-token'
	} else {
		token = uni.getStorageSync('token').token
	}
	// console.log(token)
	return new Promise(function(resolve, reject) {
		uni.request({
			url: url,
			method: method,
			data: data,
			header: {
				'Content-Type': 'application/json',
				'X-Token': token
			},
			success: function(res) {
				resolve(res.data)
			},
			fail: function(err) {
				uni.showToast({
					title: '请求失败'
				});
				reject(err);
			}
		})
	});
}

export function get(url) {
	let token = ''
	//如果本地存储没有token对象，那么取出其token属性的值的类型为undefined，可以看下控制台
	// console.log(typeof(uni.getStorageSync('token').token))
	//以下分本地有没有token，给后端传heaer，为了简便起见，没有token就用了个常量代替先
	if (typeof(uni.getStorageSync('token').token) == 'undefined') {
		token = 'no-token'
	} else {
		token = uni.getStorageSync('token').token
	}
	// console.log(token)
	return new Promise(function(resolve, reject) {
		uni.request({
			url: url,
			method: 'GET',
			header: {
				'X-Token': token
			},
			success: function(res) {
				resolve(res.data);
			},
			fail: function(err) {
				uni.showToast({
					title: '请求失败'
				});
				reject(err);
			}
		})
	});
}
