create table if not exists ques(
id INT(9) primary key auto_increment COMMENT '主键',
ques_desc VARCHAR(100) COMMENT '问题描述',
ques_analysis VARCHAR(200) COMMENT '问题解读',
answer CHAR(1) COMMENT '问题答案(即选项标识)',
aval_status CHAR(1) COMMENT '可用状态(1:可用 0:不可用)',
created_time DATETIME COMMENT '创建时间',
modified_time DATETIME COMMENT '更新时间',
red_packet CHAR(1) COMMENT '是否红包题 1：是 0：否',
ques_type CHAR(1) COMMENT '问题类型（1：百科2：财经3：投教)'
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库表';

create table if not exists quest_opt(
id INT(9) primary key auto_increment COMMENT '主键',
ques_id INT(9) COMMENT '问题ID',
opt_id CHAR(1) COMMENT '选项标识',
opt_desc VARCHAR(100) COMMENT '选项描述',
created_time DATETIME COMMENT '创建时间',
modified_time DATETIME COMMENT '更新时间'
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='题库选项表';

create table if not exists act(
id INT(9) primary key auto_increment COMMENT '主键',
act_time DATETIME COMMENT '活动时间',
act_status CHAR(1) COMMENT '活动状态(1:未开始, 2:进行中, 3:已结束)',
regu_score INT(9) COMMENT '普通积分',
red_score INT(9) COMMENT '红包积分',
ques_cnt INT(9) COMMENT '活动总题数',
allow_cnt INT(9) COMMENT '可参与答题人数',
attend_cnt INT(9) COMMENT '累计参与答题人数',
bingo_cnt INT(9) COMMENT '中奖人数',
promote_cnt INT(9) COMMENT '红包中奖人数',
created_time DATETIME COMMENT '创建时间',
modified_time DATETIME COMMENT '更新时间'
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动信息表';

create table if not exists act_ques(
id INT(9) primary key auto_increment COMMENT '主键',
act_id VARCHAR(12) COMMENT '活动ID',
ques_id INT(9) COMMENT '问题ID',
sort INT(9) COMMENT '序号(展示顺序)',
created_time DATETIME COMMENT '创建时间',
modified_time DATETIME COMMENT '更新时间'
 )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动所选题库表';

create table if not exists user_act_hist(
id INT(9) primary key auto_increment COMMENT '主键',
user_id VARCHAR(12) COMMENT '用户ID',
user_mobile VARCHAR(20) COMMENT '用户注册手机号',
act_id VARCHAR(12) COMMENT '活动ID',
attend_status CHAR(1) COMMENT '用户状态(1:参与中, 2:已淘汰, 3:围观, 4:退出 5:已结束)',
corrent_cnt INT(9) COMMENT '本次活动答对的题数',
gained_score INT(9) COMMENT '本次活动获得的积分',
created_time DATETIME COMMENT '创建时间',
modified_time DATETIME COMMENT '更新时间'
 )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户参与活动记录表';

create table if not exists user_ans_hist(
ID INT(9) primary key auto_increment COMMENT '主键',
user_id VARCHAR(12) COMMENT '用户ID',
act_id VARCHAR(12) COMMENT '活动ID',
ques_id INT(9) COMMENT '题目ID',
ans_opt CHAR(1) COMMENT '所填选项',
is_correct INT(1) COMMENT '是否答对(1:正确 0:错误)',
created_time DATETIME COMMENT '创建时间',
modified_time DATETIME COMMENT '更新时间',
use_revival CHAR(1) COMMENT '使用复活卡1:是 0:否'
 )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户答题记录表';

create table if not exists share_hist(
user_id VARCHAR(12) COMMENT '用户ID',
share_way CHAR(1) COMMENT '分享方式(1:微信, 2:QQ)',
created_time DATETIME COMMENT '创建时间',
modified_time DATETIME COMMENT '更新时间'
 )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分享记录表';


create table if not exists revival_card(
ID INT(9) primary key auto_increment COMMENT '主键',
user_id VARCHAR(12) COMMENT '用户ID',
card_no CHAR(12) COMMENT '复活卡号',
status CHAR(1) COMMENT '0:未使用1：已使用',
created_time DATETIME COMMENT '创建时间',
modified_time DATETIME COMMENT '更新时间'
 )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='复活卡表';

create table if not exists revival_card_hist(
ID INT(9) primary key auto_increment COMMENT '主键',
card_no CHAR(12) COMMENT '复活卡号',
act_id VARCHAR(12) COMMENT '活动ID',
ques_id INT(9) COMMENT '题目ID',
created_time DATETIME COMMENT '创建时间',
modified_time DATETIME COMMENT '更新时间'
 )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='复活卡使用记录表';

create table if not exists param_config(
ID INT(9) primary key auto_increment COMMENT '主键',
param_cat VARCHAR(12) COMMENT '参数分类',
param_desc VARCHAR(12) COMMENT '参数名',
param_value VARCHAR(12) COMMENT '参数值'
 )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='参数配置表';

create table if not exists admin(
  id INT(9) primary key auto_increment COMMENT '主键',
  user_name VARCHAR(100) COMMENT '管理员名',
  pass_word VARCHAR(100) COMMENT '密码'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录表';
