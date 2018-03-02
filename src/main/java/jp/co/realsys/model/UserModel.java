/*******************************************************************************
 *  システム名 : 学生情報管理
 *  著作権    : Copyright (C)　2002-2008　Realsys Co. Ltd. 　All Rights Reserved.
 *  会社名    : リアルシス株式会社
 *  ****************************************************************************
 *  変更履歴
 *  2008/03/20  作成　
 */
package jp.co.realsys.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * ユーザーModelクラス
 * 
 * @author Realsys
 */
public class UserModel {

	/** ユーザーID */
	@NotEmpty
	@Length(max=10)
	private String userId;
	
	/** パスワード */
	@NotEmpty
	@Length(max=10)
	private String password;
	
	/**
	 * パスワードを取得する
	 * 
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * パスワードを設定する
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * ユーザーIDを取得する
	 * 
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * ユーザーIDを設定する
	 * 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
