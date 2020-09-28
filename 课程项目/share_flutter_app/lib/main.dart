import 'package:flutter/material.dart';
import 'package:knowledge_sharing/home/page/initial_page.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: "知识分享",
      theme: ThemeData(platform: TargetPlatform.iOS),
      debugShowCheckedModeBanner: false,
      home: InitialPage(),
    );
  }
}
