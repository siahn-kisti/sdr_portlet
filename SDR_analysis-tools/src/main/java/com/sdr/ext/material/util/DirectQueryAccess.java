package com.sdr.ext.material.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.liferay.portal.kernel.dao.jdbc.DataAccess;

public class DirectQueryAccess {

	public static void getLayout() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = DataAccess.getUpgradeOptimizedConnection();
			// your custom query here
			String sql = " SELECT plid, groupid, companyid, userid, layoutid, parentlayoutid, type_, typeSettings, friendlyURL FROM layout where type_ = 'portlet' and typeSettings like '%datasearch%' ";
			String limitQuery = " LIMIT 0, 1000";
			String sqlQuery = sql + limitQuery;

			ps = con.prepareStatement(sqlQuery);
			rs = ps.executeQuery();

			while(rs.next()) {
				System.out.println(rs.getInt("plid"));
				System.out.println(rs.getInt("groupid"));
			}

		} catch (Exception exp) {
			System.out.println("ERROR: " + exp);
		} finally {
			DataAccess.cleanUp(con, ps, rs);
		}
	}
}