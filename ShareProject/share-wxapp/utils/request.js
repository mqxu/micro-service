/**
 * 封装uniapp的request
 */
export function request(url, method, data) {
	// console.log('url', url, 'method', method, 'data', data);
  console.log('token', uni.getStorageSync('token'));
	return new Promise(function(resolve, reject) {
		uni.request({
			url: url,
			method: method,
			data: data,
			header: {
				'Content-Type': 'application/json',
				'X-Token': uni.getStorageSync('token')
			},
			success: function(res) {
				// console.log('请求结果', res);
				resolve(res.data)
			},
			fail: function(err) {
				uni.showToast({
					title: '请求失败',
					duration: 2000
				});
				reject(err);
			}
		})
	});
}

export function get(url) {
	console.log('token', uni.getStorageSync('token'));
	return new Promise(function(resolve, reject) {
		uni.request({
			url: url,
			method: 'GET',
			header: {
				'X-Token': uni.getStorageSync('token').token
			},
			success: function(res) {
				resolve(res.data);
				// console.log(res.data)
			},
			fail: function(err) {
				uni.showToast({
					title: '请求失败',
					duration: 2000
				});
				reject(err);
			}
		})
	});
}
