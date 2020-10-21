package com.devforxkill.geekquote.dao;

import com.devforxkill.geekquote.model.Quote;

import java.util.ArrayList;

public class QuoteDaoSqlite  implements  QuoteDao{
    @Override
    public ArrayList<Quote> getQuotes() {
        return null;
    }

    @Override
    public int addQuote(Quote q) {
        return 0;
    }

    @Override
    public void updateQuote(Quote q) {

    }

    @Override
    public Quote getByID(int id) {
        return null;
    }
}
