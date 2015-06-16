package com.workerbee;

import com.workerbee.ddl.create.DatabaseCreator;
import com.workerbee.ddl.create.TableCreator;
import com.workerbee.dr.SelectFunction;
import com.workerbee.dr.SelectQuery;
import com.workerbee.dr.selectfunction.ColumnSF;

import java.util.ArrayList;
import java.util.List;

public class QueryGenerator {
  public static DatabaseCreator create(Database database){
    return new DatabaseCreator(database);
  }

  public static TableCreator create(Table table){
    return new TableCreator(table);
  }

  public static SelectQuery select(SelectFunction... selectFunctions) {
    return new SelectQuery(selectFunctions);
  }

  public static SelectQuery select(Column... columns) {
    List<SelectFunction> selectFunctions = new ArrayList<SelectFunction>(columns.length);

    for (Column column : columns) {
      selectFunctions.add(new ColumnSF(column));
    }

    return new SelectQuery(selectFunctions);
  }
}