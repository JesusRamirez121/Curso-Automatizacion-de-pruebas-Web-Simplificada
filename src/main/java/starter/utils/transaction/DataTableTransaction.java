package starter.utils.transaction;

import io.cucumber.java.DataTableType;
import starter.models.TransactionModel;

import java.util.Map;

public class DataTableTransaction {
    @DataTableType
    public TransactionModel mapToTransactionModel(Map<String, String> entry) {
        return TransactionModel.builder()
                .date(entry.get("date"))
                .amount(entry.get("amount"))
                .description(entry.get("description"))
                .build();
    }
}
