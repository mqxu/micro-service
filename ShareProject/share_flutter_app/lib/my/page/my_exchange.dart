import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:knowledge_sharing/common/common_style.dart';
import 'package:knowledge_sharing/common/constant.dart';
import 'package:knowledge_sharing/home/model/Share.dart';
import 'package:knowledge_sharing/home/widget/list_item.dart';
import 'package:knowledge_sharing/http/api.dart';
import 'package:knowledge_sharing/http/http_util.dart';

class MyExchange extends StatefulWidget {
  @override
  _MyExchangeStaet createState() => _MyExchangeStaet();
}

class _MyExchangeStaet extends State<MyExchange> {
  List<Share> exchangeList = List<Share>();

  int pageIndex = 0;
  int pageSize = 10;

  @override
  void initState() {
    _getData();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          "我的兑换",
          style: CommonStyle.title(),
        ),
        backgroundColor: Constant.mColor,
      ),
      body: Container(
        margin: EdgeInsets.only(top: 20),
        child: ListItem(exchangeList),
      ),
    );
  }

  ///请求接口，获取数据
  Future<void> _getData() async {
    ///第一个参数是你的接口名
    HttpUtil.request(
        Api.getShareInfo, {"pageSize": pageSize, "pageIndex": pageIndex},
        (code, msg, data) {
      if (code == 0) {
        for (int i = 0; i < data.length; i++) {
          Share share = Share.fromJson(data[i]);
          exchangeList.add(share);
        }
        setState(() {});
      } else {
        print("请求异常>>>>>" + msg);
      }
    }, (error) {
      print("请求出错" + error.toString());
    });
  }
}
