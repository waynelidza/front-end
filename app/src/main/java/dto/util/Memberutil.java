package dto.util;

import android.content.Context;

import dto.MembersDTO;
import dto.RequestDTO;

/**
 * Created by CodeTribe1 on 7/8/2015.
 */
public class Memberutil {
    public static RequestDTO registerMmeber(Context ctx, MembersDTO members,
                                            Integer memberID) {

        RequestDTO r = new RequestDTO();
        r.setRequestType(RequestDTO.REGISTERMB);
        r.setMembers(members);
        r.setMemberID(memberID);

        return r;
    }
    public static final int MEMBERS = 1;
}
