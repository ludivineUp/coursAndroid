package com.devforxkill.geekquote.dao;

public class DaoFactory {   // point d'accès à la base générique

    private static QuoteDao quoteDao;

    private DaoFactory(){} // interdiction d'en créer une instance

    public static QuoteDao getQuoteDao(){
        if(quoteDao == null){
            quoteDao = new QuoteDaoSqlite();
        }
        return quoteDao;    // quoteDao est un singleton
    }
}
