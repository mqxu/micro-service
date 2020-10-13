import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:knowledge_sharing/common/common_style.dart';
import 'package:knowledge_sharing/common/constant.dart';

class ScoreDetail extends StatefulWidget {
  @override
  _ScoreDetailState createState() => _ScoreDetailState();
}

class _ScoreDetailState extends State<ScoreDetail> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("积分明细", style: CommonStyle.title()),
        backgroundColor: Constant.mColor,
      ),
      body: ListView.builder(
        itemCount: 20,
        itemBuilder: (context, index) {
          return Container(
            decoration: BoxDecoration(
              border: Border(
                bottom: BorderSide(
                  color: Constant.lightGrey
                )
              )
            ),
            child: ListTile(
              title: Row(
                children: <Widget>[
                  Icon(Icons.access_time),
                  Text("2020-09-15 07:04:22 -" + " 签到")
                ],
              ),
              trailing: Text("20"),
            ),
          );  
        },
      ),
    );
  }
}
