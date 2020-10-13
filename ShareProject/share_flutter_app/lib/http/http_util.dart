import 'dart:convert';

import 'package:dio/dio.dart';

class HttpUtil {
  //默认分页页数
  final int startIndex = 0;
  //默认每页页数
  final int pageSize = 10;

  static request(
      String url,
      Map<String, Object> params,
      successBlock(int code, String msg, dynamic data),
      errorBlock(error)) async {
    Response response;
    Dio dio = Dio();
    Options options = Options();
    try {
      response = await dio.post(url, data: params, options: options);

      ///接收返回的数据
      Map map = json.decode(response.toString());
      print("请求地址是: " + url);
      print("请求参数是: " + params.toString());
      print("返回数据是: " + map.toString());
      int code = map['code'];
      String msg = map['msg'];
      dynamic data = map['data'];
      successBlock(code, msg, data);
    } on DioError catch (error) {
      print("请求地址是: " + url);
      print("请求参数是: " + params.toString());
      print("错误信息是: " + error.toString());
    }
  }
}
