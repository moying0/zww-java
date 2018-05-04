package com.bfei.icrane.core.dao;


import com.bfei.icrane.core.models.SignedSheet;

/**
 * 签到 Dao
 *
 */
public interface SignedSheetDao {

	void insert(SignedSheet signedSheet);

	SignedSheet selectOneByMemberID(String memberId);

    void updateByMemberId(String memberId);

	void updateNewDayByMemberId(String memberId);
}
