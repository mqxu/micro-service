// 后端接口基础路径
export const BASE_API_URL = 'http://share11.utools.club';
// export const BASE_API_URL = 'http://39.98.143.134:8040';

// ShareController相关接口基地址
export const SHARE_URL = BASE_API_URL + '/shares';

// 分享列表
export const SHARE_LIST_URL = SHARE_URL + '/query';
//投稿
export const CONTRIBUTE_URL = SHARE_URL + '/contribute';
//审核
export const AUDIT_URL = SHARE_URL + '/audit';
//兑换
export const EXCHANGE_URL = SHARE_URL + '/exchange';

// 最新公告
export const NOTICE_URL = BASE_API_URL + '/notices/latest';

//UserController相关接口基地址
export const USER_URL = BASE_API_URL + '/users';
//登录
export const LOGIN_URL = USER_URL + '/login';
//积分明细
export const USER_BONUS_LOG_URL = USER_URL + '/bonus-logs';
//我的投稿
export const USER_CONTRIBUTION_URL = USER_URL + '/contributions';
//签到
export const SIGN_URL = USER_URL + '/sign';








