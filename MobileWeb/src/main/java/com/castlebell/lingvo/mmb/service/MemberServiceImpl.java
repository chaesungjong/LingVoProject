package com.castlebell.lingvo.mmb.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.castlebell.lingvo.cmm.session.Member;
import com.castlebell.lingvo.mmb.dao.mmbMapper;
import com.castlebell.lingvo.mmb.dao.domain.request.RequestLogin;
import com.castlebell.lingvo.util.StringUtil;

@Service
public class MemberServiceImpl implements MemberService {

    private final mmbMapper mrMapper;

    @Autowired
    public MemberServiceImpl(mmbMapper mrMapper) {
        this.mrMapper = mrMapper;
    }

    /**
     * 로그인 처리
     */
    @Override
    public HashMap<String, Object> loginProcess(RequestLogin requestLogin, HttpSession session) {
        
        HashMap<String, Object> result = new HashMap<String, Object>();
        String retVal = "";        
        String errMsg = "";

        try{

            //로그인 처리
            mrMapper.memLogin(requestLogin);

            retVal = StringUtil.objectToString(requestLogin.getRetVal());
            errMsg = StringUtil.objectToString(requestLogin.getErrMsg());
            
            result.put("retVal", retVal);
            result.put("errMsg", errMsg);

            //로그인 실패
            if(!"0".equals(retVal)) {
                return result;
            }

            //로그인 정보 가져오기
            Map<String, Object> params = new HashMap<>();
            params.put("gubun", "MEM_USERINFO");
            params.put("userid", requestLogin.getUserid());
            params.put("ip", requestLogin.getIp());
            params.put("userkey", ""); 
            params.put("etcParam1", "");
            params.put("etcParam2", "");

            //로그인 처리
            Member member = mrMapper.memUserInfo(params);

            if(member == null) {
                result.put("retVal", "-1");
                result.put("errMsg", "로그인 정보가 없습니다.");
                return result;
            }
            //로그인 성공
            session.setAttribute("member", member);
            result.put("member", member);

        }catch(Exception e){
            e.printStackTrace();
            result.put("retVal", "-1");
            result.put("errMsg", "로그인 처리중 오류가 발생하였습니다.");
        }

        return result;
    }
    

    /**
     * 비밀번호 초기화 처리
     */
    @Override
    public HashMap<String, Object> pwdInitProcess(HttpServletRequest request, String temp_userid, String pwd, String pwdNext) {
        
        HashMap<String, Object> result = new HashMap<String, Object>();
        //String retVal = "";        
        //String errMsg = "";

        try{
 
            //비밀번호 초기화 처리SP호출
            Map<String, Object> params = new HashMap<>();
            params.put("gubun", "PWD_INIT");
            params.put("userid", temp_userid);
            params.put("ip", request.getRemoteAddr());
            params.put("userkey", ""); 
            params.put("etcParam1", pwd);
            params.put("etcParam2", pwdNext);

            //로그인 처리
            Member member = mrMapper.memUserInfo(params);

            if(member == null) {
                result.put("retVal", "-100");
                result.put("errMsg", "로그인 정보가 없습니다.");
                return result;
            }             
            result.put("member", member);             

        }catch(Exception e){
            e.printStackTrace();
            result.put("retVal", "-1");
            result.put("errMsg", "로그인 처리중 오류가 발생하였습니다.");
        }

        return result;
    }

}
