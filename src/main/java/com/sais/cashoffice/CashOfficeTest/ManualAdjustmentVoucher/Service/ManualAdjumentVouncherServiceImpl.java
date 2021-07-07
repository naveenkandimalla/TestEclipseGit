package com.sais.cashoffice.CashOfficeTest.ManualAdjustmentVoucher.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Object;
import com.sais.cashoffice.CashOfficeTest.ManualAdjustmentVoucher.model.ManualAdjumentVoucherRecordModel;
import com.sais.cashoffice.CashOfficeTest.ManualAdjustmentVoucher.repository.ManualAdjumentVouncherRepository;


@Service
public class ManualAdjumentVouncherServiceImpl implements ManualAdjumentVouncherService{
	
	@Autowired
	private ManualAdjumentVouncherRepository mvr;

	@Override
	public List<ManualAdjumentVoucherRecordModel> fetchallunpostvouchers() {
		List<ManualAdjumentVoucherRecordModel> mr =mvr.finalallunpostvouchers();
		try{
			if(mr !=null && !mr.isEmpty()){
				 
				return mr;
			}
			
		}catch(NullPointerException e){
			
			return null;
		}
		return mr;
		
		
	}

	@Override
	public double insertrecordinterfacetabletmanual(String bobinumber, char transcationtype, String createdby,
			Date creationdate,BigDecimal amount,Date period) {
		return mvr.insertrecordinterfacetabletmanual(bobinumber, transcationtype, createdby, creationdate,amount,period);
	}

	@Override
	public double updatepostingstatusTmanualadj(double manualadjustid, String postingstatus, String postedby,
			Date posteddate) {
	
		return mvr.updatepostingstatusTmanualadj(manualadjustid, postingstatus, postedby, posteddate);
	}



}
