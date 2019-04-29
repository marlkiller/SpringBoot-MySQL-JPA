package com.bespin.bcustomer.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * bcustomer实体类
 *
 * @author voidm
 * @date 2019-04-24
 */
@Entity
@Table(name = "bcustomer_20190426")
public class BcustomerEntity implements Serializable {

    private int cstId;
    private Integer cstBdgId;
    private Integer cstCszId;
    private Integer cstCmtId;
    private Integer cstCacId;
    private Integer cstCttId;
    private String cstCode;
    private String cstName;
    private String cstFirstname;
    private String cstCompany;
    private String cstDrivinglicenseNum;
    private Integer cstBirthyear;
    private Integer cstBirthmonth;
    private Integer cstBirthday;
    private Integer cstLnsId;
    private Integer cstLnwId;
    private Integer cstGndId;
    private Integer cstSltId;
    private String cstMembershipnum;
    private Timestamp cstRegistrationDt;
    private String cstIdcardnum;
    private Integer cstCreationAdvId;
    private Integer cstCreationCntId;
    private Integer cstMngtAdvId;
    private Integer cstMngtCntId;
    private String cstAddress;
    private String cstAddress2;
    private String cstAddress3;
    private String cstAddress4;
    private String cstZip;
    private Integer cstCtyId;
    private String cstCity;
    private Boolean cstValidaddressFlag;
    private String cstAreacode;
    private String cstTel;
    private Boolean cstValidtelFlag;
    private String cstMobile;
    private Boolean cstValidmobileFlag;
    private String cstWorkphone;
    private String cstWorkareacode;
    private Boolean cstValidworkphoneFlag;
    private String cstFaxareacode;
    private String cstFax;
    private Boolean cstValidfaxFlag;
    private String cstEmail;
    private Boolean cstValidemailFlag;
    private String cstAltemail;
    private Boolean cstValidaltemailFlag;
    private Integer cstOccId;
    private String cstOccupation;
    private Integer cstCtmId;
    private Integer cstCtiId;
    private Integer cstIncId;
    private Boolean cstUnsubscriptionFlag;
    private Timestamp cstFirstpurchaseDt;
    private Integer cstDtsId;
    private Boolean cstVipFlag;
    private Boolean cstDeletedFlag;
    private Boolean cstDwhupdateFlag;
    private Integer cstDedupCstId;
    private Timestamp cstCreationDt;
    private Timestamp cstUpdateDt;
    private String cstCreationuid;
    private String cstUpdateuid;

    @Id
    @Column(name = "cst_id", nullable = false)
    public int getCstId() {
        return cstId;
    }

    public void setCstId(int cstId) {
        this.cstId = cstId;
    }

    @Basic
    @Column(name = "cst_bdg_id", nullable = true)
    public Integer getCstBdgId() {
        return cstBdgId;
    }

    public void setCstBdgId(Integer cstBdgId) {
        this.cstBdgId = cstBdgId;
    }

    @Basic
    @Column(name = "cst_csz_id", nullable = true)
    public Integer getCstCszId() {
        return cstCszId;
    }

    public void setCstCszId(Integer cstCszId) {
        this.cstCszId = cstCszId;
    }

    @Basic
    @Column(name = "cst_cmt_id", nullable = true)
    public Integer getCstCmtId() {
        return cstCmtId;
    }

    public void setCstCmtId(Integer cstCmtId) {
        this.cstCmtId = cstCmtId;
    }

    @Basic
    @Column(name = "cst_cac_id", nullable = true)
    public Integer getCstCacId() {
        return cstCacId;
    }

    public void setCstCacId(Integer cstCacId) {
        this.cstCacId = cstCacId;
    }

    @Basic
    @Column(name = "cst_ctt_id", nullable = true)
    public Integer getCstCttId() {
        return cstCttId;
    }

    public void setCstCttId(Integer cstCttId) {
        this.cstCttId = cstCttId;
    }

    @Basic
    @Column(name = "cst_code", nullable = true, length = 30)
    public String getCstCode() {
        return cstCode;
    }

    public void setCstCode(String cstCode) {
        this.cstCode = cstCode;
    }

    @Basic
    @Column(name = "cst_name", nullable = true, length = 200)
    public String getCstName() {
        return cstName;
    }

    public void setCstName(String cstName) {
        this.cstName = cstName;
    }

    @Basic
    @Column(name = "cst_firstname", nullable = true, length = 200)
    public String getCstFirstname() {
        return cstFirstname;
    }

    public void setCstFirstname(String cstFirstname) {
        this.cstFirstname = cstFirstname;
    }

    @Basic
    @Column(name = "cst_company", nullable = true, length = 200)
    public String getCstCompany() {
        return cstCompany;
    }

    public void setCstCompany(String cstCompany) {
        this.cstCompany = cstCompany;
    }

    @Basic
    @Column(name = "cst_drivinglicense_num", nullable = true, length = 30)
    public String getCstDrivinglicenseNum() {
        return cstDrivinglicenseNum;
    }

    public void setCstDrivinglicenseNum(String cstDrivinglicenseNum) {
        this.cstDrivinglicenseNum = cstDrivinglicenseNum;
    }

    @Basic
    @Column(name = "cst_birthyear", nullable = true)
    public Integer getCstBirthyear() {
        return cstBirthyear;
    }

    public void setCstBirthyear(Integer cstBirthyear) {
        this.cstBirthyear = cstBirthyear;
    }

    @Basic
    @Column(name = "cst_birthmonth", nullable = true)
    public Integer getCstBirthmonth() {
        return cstBirthmonth;
    }

    public void setCstBirthmonth(Integer cstBirthmonth) {
        this.cstBirthmonth = cstBirthmonth;
    }

    @Basic
    @Column(name = "cst_birthday", nullable = true)
    public Integer getCstBirthday() {
        return cstBirthday;
    }

    public void setCstBirthday(Integer cstBirthday) {
        this.cstBirthday = cstBirthday;
    }

    @Basic
    @Column(name = "cst_lns_id", nullable = true)
    public Integer getCstLnsId() {
        return cstLnsId;
    }

    public void setCstLnsId(Integer cstLnsId) {
        this.cstLnsId = cstLnsId;
    }

    @Basic
    @Column(name = "cst_lnw_id", nullable = true)
    public Integer getCstLnwId() {
        return cstLnwId;
    }

    public void setCstLnwId(Integer cstLnwId) {
        this.cstLnwId = cstLnwId;
    }

    @Basic
    @Column(name = "cst_gnd_id", nullable = true)
    public Integer getCstGndId() {
        return cstGndId;
    }

    public void setCstGndId(Integer cstGndId) {
        this.cstGndId = cstGndId;
    }

    @Basic
    @Column(name = "cst_slt_id", nullable = true)
    public Integer getCstSltId() {
        return cstSltId;
    }

    public void setCstSltId(Integer cstSltId) {
        this.cstSltId = cstSltId;
    }

    @Basic
    @Column(name = "cst_membershipnum", nullable = true, length = 20)
    public String getCstMembershipnum() {
        return cstMembershipnum;
    }

    public void setCstMembershipnum(String cstMembershipnum) {
        this.cstMembershipnum = cstMembershipnum;
    }

    @Basic
    @Column(name = "cst_registration_dt", nullable = true)
    public Timestamp getCstRegistrationDt() {
        return cstRegistrationDt;
    }

    public void setCstRegistrationDt(Timestamp cstRegistrationDt) {
        this.cstRegistrationDt = cstRegistrationDt;
    }

    @Basic
    @Column(name = "cst_idcardnum", nullable = true, length = 20)
    public String getCstIdcardnum() {
        return cstIdcardnum;
    }

    public void setCstIdcardnum(String cstIdcardnum) {
        this.cstIdcardnum = cstIdcardnum;
    }

    @Basic
    @Column(name = "cst_creation_adv_id", nullable = true)
    public Integer getCstCreationAdvId() {
        return cstCreationAdvId;
    }

    public void setCstCreationAdvId(Integer cstCreationAdvId) {
        this.cstCreationAdvId = cstCreationAdvId;
    }

    @Basic
    @Column(name = "cst_creation_cnt_id", nullable = true)
    public Integer getCstCreationCntId() {
        return cstCreationCntId;
    }

    public void setCstCreationCntId(Integer cstCreationCntId) {
        this.cstCreationCntId = cstCreationCntId;
    }

    @Basic
    @Column(name = "cst_mngt_adv_id", nullable = true)
    public Integer getCstMngtAdvId() {
        return cstMngtAdvId;
    }

    public void setCstMngtAdvId(Integer cstMngtAdvId) {
        this.cstMngtAdvId = cstMngtAdvId;
    }

    @Basic
    @Column(name = "cst_mngt_cnt_id", nullable = true)
    public Integer getCstMngtCntId() {
        return cstMngtCntId;
    }

    public void setCstMngtCntId(Integer cstMngtCntId) {
        this.cstMngtCntId = cstMngtCntId;
    }

    @Basic
    @Column(name = "cst_address", nullable = true, length = 300)
    public String getCstAddress() {
        return cstAddress;
    }

    public void setCstAddress(String cstAddress) {
        this.cstAddress = cstAddress;
    }

    @Basic
    @Column(name = "cst_address2", nullable = true, length = 300)
    public String getCstAddress2() {
        return cstAddress2;
    }

    public void setCstAddress2(String cstAddress2) {
        this.cstAddress2 = cstAddress2;
    }

    @Basic
    @Column(name = "cst_address3", nullable = true, length = 300)
    public String getCstAddress3() {
        return cstAddress3;
    }

    public void setCstAddress3(String cstAddress3) {
        this.cstAddress3 = cstAddress3;
    }

    @Basic
    @Column(name = "cst_address4", nullable = true, length = 300)
    public String getCstAddress4() {
        return cstAddress4;
    }

    public void setCstAddress4(String cstAddress4) {
        this.cstAddress4 = cstAddress4;
    }

    @Basic
    @Column(name = "cst_zip", nullable = true, length = 10)
    public String getCstZip() {
        return cstZip;
    }

    public void setCstZip(String cstZip) {
        this.cstZip = cstZip;
    }

    @Basic
    @Column(name = "cst_cty_id", nullable = true)
    public Integer getCstCtyId() {
        return cstCtyId;
    }

    public void setCstCtyId(Integer cstCtyId) {
        this.cstCtyId = cstCtyId;
    }

    @Basic
    @Column(name = "cst_city", nullable = true, length = 200)
    public String getCstCity() {
        return cstCity;
    }

    public void setCstCity(String cstCity) {
        this.cstCity = cstCity;
    }

    @Basic
    @Column(name = "cst_validaddress_flag", nullable = true)
    public Boolean getCstValidaddressFlag() {
        return cstValidaddressFlag;
    }

    public void setCstValidaddressFlag(Boolean cstValidaddressFlag) {
        this.cstValidaddressFlag = cstValidaddressFlag;
    }

    @Basic
    @Column(name = "cst_areacode", nullable = true, length = 20)
    public String getCstAreacode() {
        return cstAreacode;
    }

    public void setCstAreacode(String cstAreacode) {
        this.cstAreacode = cstAreacode;
    }

    @Basic
    @Column(name = "cst_tel", nullable = true, length = 30)
    public String getCstTel() {
        return cstTel;
    }

    public void setCstTel(String cstTel) {
        this.cstTel = cstTel;
    }

    @Basic
    @Column(name = "cst_validtel_flag", nullable = true)
    public Boolean getCstValidtelFlag() {
        return cstValidtelFlag;
    }

    public void setCstValidtelFlag(Boolean cstValidtelFlag) {
        this.cstValidtelFlag = cstValidtelFlag;
    }

    @Basic
    @Column(name = "cst_mobile", nullable = true, length = 30)
    public String getCstMobile() {
        return cstMobile;
    }

    public void setCstMobile(String cstMobile) {
        this.cstMobile = cstMobile;
    }

    @Basic
    @Column(name = "cst_validmobile_flag", nullable = true)
    public Boolean getCstValidmobileFlag() {
        return cstValidmobileFlag;
    }

    public void setCstValidmobileFlag(Boolean cstValidmobileFlag) {
        this.cstValidmobileFlag = cstValidmobileFlag;
    }

    @Basic
    @Column(name = "cst_workphone", nullable = true, length = 30)
    public String getCstWorkphone() {
        return cstWorkphone;
    }

    public void setCstWorkphone(String cstWorkphone) {
        this.cstWorkphone = cstWorkphone;
    }

    @Basic
    @Column(name = "cst_workareacode", nullable = true, length = 20)
    public String getCstWorkareacode() {
        return cstWorkareacode;
    }

    public void setCstWorkareacode(String cstWorkareacode) {
        this.cstWorkareacode = cstWorkareacode;
    }

    @Basic
    @Column(name = "cst_validworkphone_flag", nullable = true)
    public Boolean getCstValidworkphoneFlag() {
        return cstValidworkphoneFlag;
    }

    public void setCstValidworkphoneFlag(Boolean cstValidworkphoneFlag) {
        this.cstValidworkphoneFlag = cstValidworkphoneFlag;
    }

    @Basic
    @Column(name = "cst_faxareacode", nullable = true, length = 20)
    public String getCstFaxareacode() {
        return cstFaxareacode;
    }

    public void setCstFaxareacode(String cstFaxareacode) {
        this.cstFaxareacode = cstFaxareacode;
    }

    @Basic
    @Column(name = "cst_fax", nullable = true, length = 30)
    public String getCstFax() {
        return cstFax;
    }

    public void setCstFax(String cstFax) {
        this.cstFax = cstFax;
    }

    @Basic
    @Column(name = "cst_validfax_flag", nullable = true)
    public Boolean getCstValidfaxFlag() {
        return cstValidfaxFlag;
    }

    public void setCstValidfaxFlag(Boolean cstValidfaxFlag) {
        this.cstValidfaxFlag = cstValidfaxFlag;
    }

    @Basic
    @Column(name = "cst_email", nullable = true, length = 100)
    public String getCstEmail() {
        return cstEmail;
    }

    public void setCstEmail(String cstEmail) {
        this.cstEmail = cstEmail;
    }

    @Basic
    @Column(name = "cst_validemail_flag", nullable = true)
    public Boolean getCstValidemailFlag() {
        return cstValidemailFlag;
    }

    public void setCstValidemailFlag(Boolean cstValidemailFlag) {
        this.cstValidemailFlag = cstValidemailFlag;
    }

    @Basic
    @Column(name = "cst_altemail", nullable = true, length = 100)
    public String getCstAltemail() {
        return cstAltemail;
    }

    public void setCstAltemail(String cstAltemail) {
        this.cstAltemail = cstAltemail;
    }

    @Basic
    @Column(name = "cst_validaltemail_flag", nullable = true)
    public Boolean getCstValidaltemailFlag() {
        return cstValidaltemailFlag;
    }

    public void setCstValidaltemailFlag(Boolean cstValidaltemailFlag) {
        this.cstValidaltemailFlag = cstValidaltemailFlag;
    }

    @Basic
    @Column(name = "cst_occ_id", nullable = true)
    public Integer getCstOccId() {
        return cstOccId;
    }

    public void setCstOccId(Integer cstOccId) {
        this.cstOccId = cstOccId;
    }

    @Basic
    @Column(name = "cst_occupation", nullable = true, length = 200)
    public String getCstOccupation() {
        return cstOccupation;
    }

    public void setCstOccupation(String cstOccupation) {
        this.cstOccupation = cstOccupation;
    }

    @Basic
    @Column(name = "cst_ctm_id", nullable = true)
    public Integer getCstCtmId() {
        return cstCtmId;
    }

    public void setCstCtmId(Integer cstCtmId) {
        this.cstCtmId = cstCtmId;
    }

    @Basic
    @Column(name = "cst_cti_id", nullable = true)
    public Integer getCstCtiId() {
        return cstCtiId;
    }

    public void setCstCtiId(Integer cstCtiId) {
        this.cstCtiId = cstCtiId;
    }

    @Basic
    @Column(name = "cst_inc_id", nullable = true)
    public Integer getCstIncId() {
        return cstIncId;
    }

    public void setCstIncId(Integer cstIncId) {
        this.cstIncId = cstIncId;
    }

    @Basic
    @Column(name = "cst_unsubscription_flag", nullable = true)
    public Boolean getCstUnsubscriptionFlag() {
        return cstUnsubscriptionFlag;
    }

    public void setCstUnsubscriptionFlag(Boolean cstUnsubscriptionFlag) {
        this.cstUnsubscriptionFlag = cstUnsubscriptionFlag;
    }

    @Basic
    @Column(name = "cst_firstpurchase_dt", nullable = true)
    public Timestamp getCstFirstpurchaseDt() {
        return cstFirstpurchaseDt;
    }

    public void setCstFirstpurchaseDt(Timestamp cstFirstpurchaseDt) {
        this.cstFirstpurchaseDt = cstFirstpurchaseDt;
    }

    @Basic
    @Column(name = "cst_dts_id", nullable = true)
    public Integer getCstDtsId() {
        return cstDtsId;
    }

    public void setCstDtsId(Integer cstDtsId) {
        this.cstDtsId = cstDtsId;
    }

    @Basic
    @Column(name = "cst_vip_flag", nullable = true)
    public Boolean getCstVipFlag() {
        return cstVipFlag;
    }

    public void setCstVipFlag(Boolean cstVipFlag) {
        this.cstVipFlag = cstVipFlag;
    }

    @Basic
    @Column(name = "cst_deleted_flag", nullable = true)
    public Boolean getCstDeletedFlag() {
        return cstDeletedFlag;
    }

    public void setCstDeletedFlag(Boolean cstDeletedFlag) {
        this.cstDeletedFlag = cstDeletedFlag;
    }

    @Basic
    @Column(name = "cst_dwhupdate_flag", nullable = true)
    public Boolean getCstDwhupdateFlag() {
        return cstDwhupdateFlag;
    }

    public void setCstDwhupdateFlag(Boolean cstDwhupdateFlag) {
        this.cstDwhupdateFlag = cstDwhupdateFlag;
    }

    @Basic
    @Column(name = "cst_dedup_cst_id", nullable = true)
    public Integer getCstDedupCstId() {
        return cstDedupCstId;
    }

    public void setCstDedupCstId(Integer cstDedupCstId) {
        this.cstDedupCstId = cstDedupCstId;
    }

    @Basic
    @Column(name = "cst_creation_dt", nullable = true)
    public Timestamp getCstCreationDt() {
        return cstCreationDt;
    }

    public void setCstCreationDt(Timestamp cstCreationDt) {
        this.cstCreationDt = cstCreationDt;
    }

    @Basic
    @Column(name = "cst_update_dt", nullable = true)
    public Timestamp getCstUpdateDt() {
        return cstUpdateDt;
    }

    public void setCstUpdateDt(Timestamp cstUpdateDt) {
        this.cstUpdateDt = cstUpdateDt;
    }

    @Basic
    @Column(name = "cst_creationuid", nullable = true, length = 50)
    public String getCstCreationuid() {
        return cstCreationuid;
    }

    public void setCstCreationuid(String cstCreationuid) {
        this.cstCreationuid = cstCreationuid;
    }

    @Basic
    @Column(name = "cst_updateuid", nullable = true, length = 50)
    public String getCstUpdateuid() {
        return cstUpdateuid;
    }

    public void setCstUpdateuid(String cstUpdateuid) {
        this.cstUpdateuid = cstUpdateuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BcustomerEntity that = (BcustomerEntity) o;
        return cstId == that.cstId &&
                Objects.equals(cstBdgId, that.cstBdgId) &&
                Objects.equals(cstCszId, that.cstCszId) &&
                Objects.equals(cstCmtId, that.cstCmtId) &&
                Objects.equals(cstCacId, that.cstCacId) &&
                Objects.equals(cstCttId, that.cstCttId) &&
                Objects.equals(cstCode, that.cstCode) &&
                Objects.equals(cstName, that.cstName) &&
                Objects.equals(cstFirstname, that.cstFirstname) &&
                Objects.equals(cstCompany, that.cstCompany) &&
                Objects.equals(cstDrivinglicenseNum, that.cstDrivinglicenseNum) &&
                Objects.equals(cstBirthyear, that.cstBirthyear) &&
                Objects.equals(cstBirthmonth, that.cstBirthmonth) &&
                Objects.equals(cstBirthday, that.cstBirthday) &&
                Objects.equals(cstLnsId, that.cstLnsId) &&
                Objects.equals(cstLnwId, that.cstLnwId) &&
                Objects.equals(cstGndId, that.cstGndId) &&
                Objects.equals(cstSltId, that.cstSltId) &&
                Objects.equals(cstMembershipnum, that.cstMembershipnum) &&
                Objects.equals(cstRegistrationDt, that.cstRegistrationDt) &&
                Objects.equals(cstIdcardnum, that.cstIdcardnum) &&
                Objects.equals(cstCreationAdvId, that.cstCreationAdvId) &&
                Objects.equals(cstCreationCntId, that.cstCreationCntId) &&
                Objects.equals(cstMngtAdvId, that.cstMngtAdvId) &&
                Objects.equals(cstMngtCntId, that.cstMngtCntId) &&
                Objects.equals(cstAddress, that.cstAddress) &&
                Objects.equals(cstAddress2, that.cstAddress2) &&
                Objects.equals(cstAddress3, that.cstAddress3) &&
                Objects.equals(cstAddress4, that.cstAddress4) &&
                Objects.equals(cstZip, that.cstZip) &&
                Objects.equals(cstCtyId, that.cstCtyId) &&
                Objects.equals(cstCity, that.cstCity) &&
                Objects.equals(cstValidaddressFlag, that.cstValidaddressFlag) &&
                Objects.equals(cstAreacode, that.cstAreacode) &&
                Objects.equals(cstTel, that.cstTel) &&
                Objects.equals(cstValidtelFlag, that.cstValidtelFlag) &&
                Objects.equals(cstMobile, that.cstMobile) &&
                Objects.equals(cstValidmobileFlag, that.cstValidmobileFlag) &&
                Objects.equals(cstWorkphone, that.cstWorkphone) &&
                Objects.equals(cstWorkareacode, that.cstWorkareacode) &&
                Objects.equals(cstValidworkphoneFlag, that.cstValidworkphoneFlag) &&
                Objects.equals(cstFaxareacode, that.cstFaxareacode) &&
                Objects.equals(cstFax, that.cstFax) &&
                Objects.equals(cstValidfaxFlag, that.cstValidfaxFlag) &&
                Objects.equals(cstEmail, that.cstEmail) &&
                Objects.equals(cstValidemailFlag, that.cstValidemailFlag) &&
                Objects.equals(cstAltemail, that.cstAltemail) &&
                Objects.equals(cstValidaltemailFlag, that.cstValidaltemailFlag) &&
                Objects.equals(cstOccId, that.cstOccId) &&
                Objects.equals(cstOccupation, that.cstOccupation) &&
                Objects.equals(cstCtmId, that.cstCtmId) &&
                Objects.equals(cstCtiId, that.cstCtiId) &&
                Objects.equals(cstIncId, that.cstIncId) &&
                Objects.equals(cstUnsubscriptionFlag, that.cstUnsubscriptionFlag) &&
                Objects.equals(cstFirstpurchaseDt, that.cstFirstpurchaseDt) &&
                Objects.equals(cstDtsId, that.cstDtsId) &&
                Objects.equals(cstVipFlag, that.cstVipFlag) &&
                Objects.equals(cstDeletedFlag, that.cstDeletedFlag) &&
                Objects.equals(cstDwhupdateFlag, that.cstDwhupdateFlag) &&
                Objects.equals(cstDedupCstId, that.cstDedupCstId) &&
                Objects.equals(cstCreationDt, that.cstCreationDt) &&
                Objects.equals(cstUpdateDt, that.cstUpdateDt) &&
                Objects.equals(cstCreationuid, that.cstCreationuid) &&
                Objects.equals(cstUpdateuid, that.cstUpdateuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cstId, cstBdgId, cstCszId, cstCmtId, cstCacId, cstCttId, cstCode, cstName, cstFirstname, cstCompany, cstDrivinglicenseNum, cstBirthyear, cstBirthmonth, cstBirthday, cstLnsId, cstLnwId, cstGndId, cstSltId, cstMembershipnum, cstRegistrationDt, cstIdcardnum, cstCreationAdvId, cstCreationCntId, cstMngtAdvId, cstMngtCntId, cstAddress, cstAddress2, cstAddress3, cstAddress4, cstZip, cstCtyId, cstCity, cstValidaddressFlag, cstAreacode, cstTel, cstValidtelFlag, cstMobile, cstValidmobileFlag, cstWorkphone, cstWorkareacode, cstValidworkphoneFlag, cstFaxareacode, cstFax, cstValidfaxFlag, cstEmail, cstValidemailFlag, cstAltemail, cstValidaltemailFlag, cstOccId, cstOccupation, cstCtmId, cstCtiId, cstIncId, cstUnsubscriptionFlag, cstFirstpurchaseDt, cstDtsId, cstVipFlag, cstDeletedFlag, cstDwhupdateFlag, cstDedupCstId, cstCreationDt, cstUpdateDt, cstCreationuid, cstUpdateuid);
    }
}