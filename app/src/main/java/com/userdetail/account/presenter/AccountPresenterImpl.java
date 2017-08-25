package com.userdetail.account.presenter;

import android.content.Context;

import com.userdetail.account.model.Account;
import com.userdetail.account.model.AccountModel;
import com.userdetail.account.utils.Response;
import com.userdetail.account.view.IAccountView;

import java.util.List;


/**
 * Class is offered to VIEW,MODEL to communicate with PRESENTER
 */
public class AccountPresenterImpl implements IAccountPresenter {

    private AccountModel model;
    private IAccountView view;

    public AccountPresenterImpl(IAccountView view) {
        model = new AccountModel(this);
        this.view=view;
    }

    @Override
    public void getAccountDetails(Context context,int accountType) {
        model.fetchDetails(context,accountType);
    }

    @Override
    public void onTaskCompleted(List<Account> result,Response responseObject) {
        if (result != null)
            view.onResponseSuccess(result);
        else
            view.onResponseFailure(responseObject);
    }

}
