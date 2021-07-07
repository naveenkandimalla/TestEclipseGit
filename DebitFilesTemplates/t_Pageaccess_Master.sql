prompt Importing table t_Pageaccess_Master...
set feedback off
set define off
insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (274, 'PPC', 'Partial Misallocation Correction', '/pages/paypoint/transaction/polPartialCorrection.zul', 6, to_date('18-01-2012 08:39:02', 'dd-mm-yyyy hh24:mi:ss'), 'bliladmin', to_date('18-01-2012 08:39:02', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null, null, null);

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (275, 'DDSB', 'Debit File For Stanbic', '/pages/hosttohost/stanbic/gendebitforstanbic.zul', 10, to_date('08-06-2019 11:12:10', 'dd-mm-yyyy hh24:mi:ss'), 'bliladmin', to_date('08-06-2019 11:12:10', 'dd-mm-yyyy hh24:mi:ss'), 'bliladmin', 'debit file generattion for stanbic bank', 'DEBIT FILE GENERATION', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (276, 'ADF', 'Authorize Debit File', '/pages/hosttohost/stanbic/AuthorizeDrForStanbic.zul', 10, to_date('08-06-2019 11:12:10', 'dd-mm-yyyy hh24:mi:ss'), 'bliladmin', to_date('08-06-2019 11:12:10', 'dd-mm-yyyy hh24:mi:ss'), 'bliladmin', 'debit file authorization for stanbic bank', 'DEBIT FILE AUTHORIZATION', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (277, 'STATUS', 'File Status', '/pages/hosttohost/stanbic/DebitFileStatus.zul', 10, to_date('08-06-2019 11:12:13', 'dd-mm-yyyy hh24:mi:ss'), 'bliladmin', to_date('08-06-2019 11:12:13', 'dd-mm-yyyy hh24:mi:ss'), 'bliladmin', 'Check Debitfile status for stanbic', 'FILE STATUS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (278, 'RJCTRPT', 'Rejection Report', '/pages/hosttohost/stanbic/stanbicrejectionreport.zul', 10, to_date('08-06-2019 11:12:13', 'dd-mm-yyyy hh24:mi:ss'), 'bliladmin', to_date('08-06-2019 11:12:13', 'dd-mm-yyyy hh24:mi:ss'), 'bliladmin', 'Rejection report for stanbic', 'Rejection report', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (1, 'CAS', 'Set-Up Cashier', '/pages/cashoffice/master/Cashier.zul', 1, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE MASTER', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (5, 'PYM', 'Set-Up Payment Method', '/pages/cashoffice/master/paymentmethod.zul', 1, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE MASTER', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (10, 'APP', 'Set-Up Applications', '/pages/cashoffice/master/application.zul', 1, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE MASTER', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (15, 'COF', 'Set-Up Cash Office', '/pages/cashoffice/master/SetUpCashOffice.zul', 1, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE MASTER', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (20, 'ASC', 'Assign Cashier', '/pages/cashoffice/master/assignCashier.zul', 1, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE MASTER', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (25, 'COA', 'Cash Office Activity', '/pages/cashoffice/transaction/cashOfficeActivities.zul', 2, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (30, 'CTA', 'Cash Till Activity', '/pages/cashoffice/transaction/CashTillActivities.zul', 2, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (35, 'RCP', 'Payment Receipt', '/pages/cashoffice/transaction/saveReceipt.zul', 2, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (40, 'QRC', 'Query Receipt', '/pages/cashoffice/transaction/queryReceipt.zul', 2, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (45, 'CPR', 'Cancel Payment Receipt', '/pages/cashoffice/transaction/cancelReceipt.zul', 2, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (50, 'ARC', 'Approve Receipt Cancellation', '/pages/cashoffice/transaction/approveCancelReceipt.zul', 2, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (55, 'BDS', 'Print Bank Deposit Slip', '/pages/cashoffice/transaction/BankDepositSlip.zul', 2, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (60, 'RPO', 'Receipt Posting', '/pages/cashoffice/transaction/receiptPosting.zul', 2, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (65, 'AVR', 'Adjustment Voucher- Receipt', '/pages/cashoffice/transaction/receiptAdjustment.zul', 2, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (70, 'SLE', 'Secured Loan Enquiry', '/pages/cashoffice/transaction/queryLoan.zul', 2, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (75, 'DRL', 'Daily Receipt Listing', '/pages/reports/cashoffice/dailyReceipts.zul', 3, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (80, 'RPR', 'Re-print Receipt', '/pages/reports/cashoffice/rePrintReceiptReport.zul', 3, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (85, 'RDS', 'Re-Print Deposit Slip', '/pages/reports/cashoffice/rePrintDepositSlip.zul', 3, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (90, 'CBB', 'Collection By Branch', '/pages/reports/cashoffice/cashOfficeCollection.zul', 3, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (95, 'CBS', 'Collection By Application - Summary', '/pages/reports/cashoffice/appCollection.zul', 3, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (100, 'CBD', 'Collection By Application - Detail', '/pages/reports/cashoffice/appCollectionDet.zul', 3, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (105, 'CSS', 'Cashier Assignment', '/pages/reports/cashoffice/cashierAssign.zul', 3, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'CASH OFFICE REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (110, 'TEM', 'Debit File Template Assignment', '/pages/paypoint/master/assigntemplate.zul', 4, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'PAYPOINT MASTER', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (115, 'FDN', 'File Designer', '/pages/paypoint/master/fileFormat.zul', 4, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'PAYPOINT MASTER', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (120, 'MAN', 'Generate Debit File', '/pages/paypoint/transaction/generatedebitFile.zul', 5, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'PAYPOINT TRANSACTION', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (125, 'SPM', 'Split/Merge Debit File', '/pages/paypoint/transaction/SplitMerge.zul', 5, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'PAYPOINT TRANSACTION', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (130, 'SMS', 'Split/Merge Search', '/pages/paypoint/transaction/splitMergeSearch.zul', 5, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'PAYPOINT TRANSACTION', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (135, 'UPC', 'Upload Credit File', '/pages/paypoint/transaction/uploadcreditfile.zul', 5, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'PAYPOINT TRANSACTION', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (140, 'ALC', 'Electronic Allocation', '/pages/paypoint/transaction/allocation.zul', 6, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'PAYPOINT TRANSACTION', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (145, 'MAL', 'Manual Allocation', '/pages/paypoint/transaction/Paypoint_Manual_Allocation.zul', 6, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'PAYPOINT TRANSACTION', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (150, 'BST', 'Direct Debit Processing', '/pages/paypoint/transaction/bankStatement.zul', 6, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'PAYPOINT TRANSACTION', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (155, 'BSO', 'Bank Stop Order Processing', '/pages/paypoint/transaction/bankStatementBSO.zul', 6, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (160, 'BSP', 'Bank Statement Posting', '/pages/paypoint/transaction/bankStatementPosting.zul', 6, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'PAYPOINT TRANSACTION', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (165, 'MAC', 'MisAllocation Correction', '/pages/paypoint/transaction/PolicyMisallocationCorrection.zul', 6, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, 'PAYPOINT TRANSACTION', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (170, 'PMC', 'Paypoint Misallocation', '/pages/paypoint/transaction/payPointMisallocCorrection.zul', 6, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'PAYPOINT TRANSACTION', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (175, 'AVB', 'Bank Statement Adjustment Voucher', '/pages/paypoint/transaction/bkStmtAdjustment.zul', 6, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (180, 'MAD', 'Manual Adjustment Voucher', '/pages/paypoint/transaction/manualadjustment.zul', 6, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (185, 'PCH', 'Paypoint Collection History', '/pages/paypoint/transaction/paypointcollectionhistory.zul', 6, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('12-08-2013 09:51:19', 'dd-mm-yyyy hh24:mi:ss'), 'admin', null, null, null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (200, 'OAU', 'Overs and Unders', '/pages/reports/paypoints/oversUnders.zul', 7, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'PAYPOINT REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (205, 'REJ', 'Rejections', '/pages/reports/paypoints/rejections.zul', 7, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'PAYPOINT REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (210, 'PDS', 'Paypoint Summary', '/pages/reports/paypoints/paypointDebitSummary.zul', 7, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'PAYPOINT REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (215, 'UCR', 'Unallocated Cash Receipts', '/pages/reports/paypoints/unallocCashReceipts.zul', 7, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'PAYPOINT REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (220, 'UMC', 'Unmatched Credits', '/pages/reports/paypoints/unmatchedCredits.zul', 7, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'PAYPOINT REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (225, 'RAC', 'Receipt Allocation Status', '/pages/reports/paypoints/receiptAllocation.zul', 7, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'PAYPOINT  REPORTS', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (230, 'UNB', 'Unspecified Bank', '/pages/reports/paypoints/unspecifiedBank.zul', 7, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (235, 'UNG', 'Unspecified GSO-ESO', '/pages/reports/paypoints/unspecifiedGSO.zul', 7, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (240, 'BANK', 'BankStatement', '/pages/reports/paypoints/bankStmtreport.zul', 7, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (245, 'ADJREPORT', 'Manual Adjustment Report', '/pages/reports/paypoints/manualAdjustmentReport.zul', 7, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (250, 'UMT', 'User Management', '/pages/admin/mgt/userManagement.zul', 8, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'ADMIN', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (255, 'ASR', 'Assign Role', '/pages/admin/mgt/createrole.zul', 8, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'ADMIN', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (260, 'GRM', 'Group Master', '/pages/admin/mgt/groupMaster.zul', 8, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'ADMIN', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (265, 'PSS', 'Page Access', '/pages/admin/mgt/pageAccessMaster.zul', 8, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'ADMIN', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (270, 'PSM', 'Password Management', '/pages/user/mgt/changePassword.zul', 9, to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('09-06-2011 17:01:26', 'dd-mm-yyyy hh24:mi:ss'), null, null, 'USER', null, null, null, null, null, '1');

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (272, 'RST', 'Reset Password', '/pages/admin/mgt/resetpassword.zul', 8, to_date('14-06-2011 16:51:36', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('14-06-2011 16:51:36', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null, null, null);

insert into t_Pageaccess_Master (PAGEACCESS_ID, SCREEN_CODE, SCREEN_DESC, URL, MODULE_ID, CREATION_DATE, CREATED_BY, MODIFIED_DATETIME, MODIFIED_BY, COMMENTS, ATTRIBUTE1, ATTRIBUTE2, ATTRIBUTE3, ATTRIBUTE4, ATTRIBUTE5, ATTRIBUTE6, ENABLED)
values (273, 'BKSTALLOC', 'Bank Statement Allocation', '/pages/reports/paypoints/bankStmtAlloc.zul', 7, to_date('08-08-2011 18:32:57', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('08-08-2011 18:32:57', 'dd-mm-yyyy hh24:mi:ss'), null, null, null, null, null, null, null, null, null);

prompt Done.
