import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:knowledge_sharing/contribution/page/contribution_page.dart';
import 'package:knowledge_sharing/home/page/home_page.dart';
import 'package:knowledge_sharing/my/page/my_page.dart';

class InitialPage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<InitialPage> {
  List<Widget> _bodys = [HomePage(), ContributionPage(), MyPage()];
  int currentIndex = 0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: IndexedStack(
        children: _bodys,
        index: currentIndex,
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: [
          BottomNavigationBarItem(
              icon: _getIcon((currentIndex == 0)
                  ? "images/shouye1.png"
                  : "images/shouye.png"),
              title: _getTitle("首页")),
          BottomNavigationBarItem(
              icon: _getIcon((currentIndex == 1)
                  ? "images/tougao1.png"
                  : "images/tougao.png"),
              title: _getTitle("投稿")),
          BottomNavigationBarItem(
              icon: _getIcon(
                  (currentIndex == 2) ? "images/wode1.png" : "images/wode.png"),
              title: _getTitle("我的")),
        ],
        currentIndex: currentIndex,
        selectedFontSize: 18,
        unselectedFontSize: 16,
        selectedItemColor: Colors.red,
        onTap: (value) {
          _changeIndex(value);
        },
      ),
    );
  }

   Widget _getIcon(String url) {
    return Container(
      height: 24,
      width: 24,
      child: Image.asset(
        url,
        fit: BoxFit.cover,
        color: Colors.red,
      ),
    );
  }

   Widget _getTitle(String title) {
    return Container(
      child: Text(
        title,
        style: TextStyle(fontSize: 16),
      ),
    );
  }

  void _changeIndex(value) {
    setState(() {
      currentIndex = value;
    });
  }
}
