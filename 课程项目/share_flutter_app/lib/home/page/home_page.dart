import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:knowledge_sharing/common/common_style.dart';
import 'package:knowledge_sharing/common/constant.dart';
import 'package:knowledge_sharing/home/model/Share.dart';
import 'package:knowledge_sharing/home/widget/list_item.dart';
import 'package:knowledge_sharing/http/api.dart';
import 'package:knowledge_sharing/http/http_util.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> with TickerProviderStateMixin {
  TabController _tabController;

  ///定义数据集合
  List<Share> shareLists = List();

  int pageIndex = 0;
  int pageSize = 10;

  @override
  void initState() {
    _getData();
    _tabController = TabController(length: 2, initialIndex: 0, vsync: this);
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Constant.mColor,
          title: Container(
            child: Text("首页", style: CommonStyle.title()),
          ),
          centerTitle: true,
        ),
        body: _buildBody());
  }

  Widget _buildTabbar() {
    return Container(
      height: 50,
      width: MediaQuery.of(context).size.width,
      child: TabBar(
        controller: _tabController,
        indicator: UnderlineTabIndicator(
          borderSide: BorderSide(color: Color(0xFFeb544d), width: 3),
          insets: EdgeInsets.symmetric(horizontal: 60),
        ),
        indicatorPadding: EdgeInsets.only(bottom: 40),
        unselectedLabelColor: Colors.grey,
        unselectedLabelStyle: TextStyle(color: Colors.grey),
        labelColor: Colors.black,
        tabs: <Widget>[
          Tab(
            child: Text(
              "发现",
              style: CommonStyle.topTabSelected(),
            ),
          ),
          Tab(
            child: Text("使用说明", style: CommonStyle.topTabSelected()),
          ),
        ],
      ),
    );
  }

  Widget _buildBody() {
    return Column(
      children: <Widget>[
        ///构建tabbar
        _buildTabbar(),
        Expanded(
          child: TabBarView(
            controller: _tabController,
            children: <Widget>[
              _buildFindWidgt(),
              Container(
                padding: EdgeInsets.all(20),
                child: Text(
                  "资源均为免费，兑换后即可查看下载地址: 点击我的 -> 我的兑换，即可查看、下载兑换的资源。",
                  style: CommonStyle.content(),
                ),
              )
            ],
          ),
        ),
      ],
    );
  }

  Widget _buildFindWidgt() {
    return Column(
      children: <Widget>[
        Container(
          height: 40,
          color: Color(0xFFfefbe8),
          width: MediaQuery.of(context).size.width,
          alignment: Alignment.centerLeft,
          padding: EdgeInsets.only(left: 20),
          child: Text(
            "关注微信公众号你我之书，各种专业知识推送!",
            style: CommonStyle.notice(),
          ),
        ),
        Container(
          height: 40,
          padding: EdgeInsets.fromLTRB(20, 5, 20, 5),
          child: TextField(
            decoration: InputDecoration(

                ///前缀图标
                prefixIcon: Container(
                  padding: EdgeInsets.only(left: 5, right: 5),
                  child: Image.asset(
                    "images/search.png",
                    fit: BoxFit.cover,
                  ),
                ),

                ///设置前缀图片的容器大小
                prefixIconConstraints: BoxConstraints(
                  maxWidth: 30,
                  maxHeight: 20,
                ),
                filled: true,
                fillColor: Colors.white,
                hintStyle: CommonStyle.contentLightGrey(),
                //设置内容边距
                contentPadding: EdgeInsets.only(left: 10),
                //设置边框圆润度
                border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(5),
                    borderSide: BorderSide.none),
                hintText: "请输入关键词"),
          ),
        ),
        Expanded(
          child: Container(
            margin: EdgeInsets.only(top: 10),
            child: ListItem(shareLists),
          ),
        ),
      ],
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
          shareLists.add(share);
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
