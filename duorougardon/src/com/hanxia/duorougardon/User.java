package com.hanxia.duorougardon;

import java.io.Serializable;

public class User implements Serializable {
	//�������л���id
		private static final long serialVersionUID = 1L;
		//�û�������
		public String name;
		//�û���������
		public String pwd;
		//�û�����������
		public String eamil;
		/**
		 * ��ȡ�û���
		 */
		public String getName() {
			return name;
		}
		/**
		 * �����û���
		 */
		public void setName(String name) {
			this.name = name;
		}
		/**
		 *��ȡ�û�����
		 */
		public String getPwd() {
			return pwd;
		}
		/**
		 * �����û�����
		 */
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		/**
		 * ��ȡemail
		 */
		public String getEamil() {
			return eamil;
		}
		/**
		 * �����û�����
		 */
		public void setEamil(String eamil) {
			this.eamil = eamil;
		}
		/* 
		 * ��ʽ����ʾUser�û�����������
		 */
		@Override
		public String toString() {
			return "User [name=" + name + ", pwd=" + pwd + ", eamil=" + eamil + "]";
		}

}
