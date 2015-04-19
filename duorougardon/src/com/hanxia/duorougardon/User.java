package com.hanxia.duorougardon;

import java.io.Serializable;

public class User implements Serializable {
	//定义序列化的id
		private static final long serialVersionUID = 1L;
		//用户名属性
		public String name;
		//用户密码属性
		public String pwd;
		//用户名邮箱属性
		public String eamil;
		/**
		 * 获取用户名
		 */
		public String getName() {
			return name;
		}
		/**
		 * 设置用户名
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 *获取用户密码
		 */
		public String getPwd() {
			return pwd;
		}
		/**
		 * 设置用户密码
		 */
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		/**
		 * 获取email
		 */
		public String getEamil() {
			return eamil;
		}
		/**
		 * 设置用户邮箱
		 */
		public void setEamil(String eamil) {
			this.eamil = eamil;
		}
		/* 
		 * 格式化显示User用户的所有属性
		 */
		@Override
		public String toString() {
			return "User [name=" + name + ", pwd=" + pwd + ", eamil=" + eamil + "]";
		}

}
