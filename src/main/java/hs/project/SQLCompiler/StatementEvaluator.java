package hs.project.SQLCompiler;

import hs.project.SQLCompiler.statement.enums.PrepareStatementResult;
import hs.project.SQLCompiler.statement.enums.meta.MetaStatementResult;
import hs.project.SQLCompiler.statement.enums.statement.StatementType;

import java.util.Objects;

public class StatementEvaluator {
    String statement;
    StatementType statementType;

    public StatementEvaluator(String statement) {
        this.statement = statement;
    }

    public void evaluateStatement() {
        if (!statement.isEmpty()) {
            if (statement.toCharArray()[0] == '.') {
                switch (Objects.requireNonNull(doMetaCommand())) {
                    case META_STATEMENT_SUCCESS -> {
                        //logic here
                    }
                    case META_STATEMENT_UNRECOGNIZED -> System.out.println("Command is unrecognized " + statement);
                }
            } else {
                switch (prepareStatement()) {
                    case PREPARE_SUCCESS -> {
                        executeStatement();
                        System.out.println("Executed.");
                    }
                    case PREPARE_UNRECOGNIZED_STATEMENT -> System.out.println("Statement is unrecognized " + statement);
                }
            }
        }
    }

    private void executeStatement() {
        switch (statementType) {
            case STATEMENT_INSERT -> System.out.println("Here we do the insert");
            case STATEMENT_SELECT -> System.out.println("Here we do the select");
            case STATEMENT_DELETE -> System.out.println("Here we do the delete");
        }
    }

    private MetaStatementResult doMetaCommand() {
        if (statement.equals(".exit")) {
            System.out.println("Exiting.");
            System.exit(0);
        } else {
            return MetaStatementResult.META_STATEMENT_UNRECOGNIZED;
        }
        return null;
    }

    private PrepareStatementResult prepareStatement() {
        if (statement.startsWith("insert")) {
            statementType = StatementType.STATEMENT_INSERT;
            return PrepareStatementResult.PREPARE_SUCCESS;
        }
        if (statement.startsWith("delete")) {
            statementType = StatementType.STATEMENT_DELETE;
            return PrepareStatementResult.PREPARE_SUCCESS;
        }
        if (statement.startsWith("select")) {
            statementType = StatementType.STATEMENT_SELECT;
            return PrepareStatementResult.PREPARE_SUCCESS;
        }
        return PrepareStatementResult.PREPARE_UNRECOGNIZED_STATEMENT;
    }
}
