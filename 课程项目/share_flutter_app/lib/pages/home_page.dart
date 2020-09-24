import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("首页"),
      ),
      body: Center(
        child: Text(
          'Flutter 真机首页，我就想抄抄学生的作业～',
          style: TextStyle(
            fontSize: 18,
          ),
        ),
      ),
    );
  }
}
