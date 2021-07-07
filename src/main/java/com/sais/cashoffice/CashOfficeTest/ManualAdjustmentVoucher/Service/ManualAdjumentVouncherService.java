package com.sais.cashoffice.CashOfficeTest.ManualAdjustmentVoucher.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//import com.mysql.cj.x.protobuf.MysqlxDatatypes.Object;
import com.sais.cashoffice.CashOfficeTest.ManualAdjustmentVoucher.model.ManualAdjumentVoucherRecordModel;

public interface ManualAdjumentVouncherService {
	
	List<ManualAdjumentVoucherRecordModel> fetchallunpostvouchers();
	double insertrecordinterfacetabletmanual(String bobinumber,char transcationtype,String createdby,Date creationdate,BigDecimal amount,Date period);
	double updatepostingstatusTmanualadj(double manualadjustid,String postingstatus,String postedby,Date posteddate);


}
