package org.aion.gui.events;

import org.aion.gui.model.AccountDTO;
import org.aion.gui.model.LightAppSettings;
import org.aion.wallet.util.DataUpdater;

public class EventPublisher {
    public static final String ACCOUNT_CHANGE_EVENT_ID = "account.changed";
    public static final String ACCOUNT_UNLOCK_EVENT_ID = "account.unlock";
    public static final String SETTINGS_CHANGED_ID = "settings.changed";

    public static void fireAccountChanged(final AccountDTO account) {
        if (account != null) {
            EventBusFactory.getBus(ACCOUNT_CHANGE_EVENT_ID).post(account);
        }
    }

    public static void fireUnlockAccount(final AccountDTO account) {
        if (account != null) {
            EventBusFactory.getBus(ACCOUNT_UNLOCK_EVENT_ID).post(account);
        }
    }

    public static void fireOperationFinished(){
        EventBusFactory.getBus(DataUpdater.UI_DATA_REFRESH).post(new RefreshEvent(RefreshEvent.Type.OPERATION_FINISHED));
    }

    public static void fireApplicationSettingsChanged(final LightAppSettings settings){
        EventBusFactory.getBus(SETTINGS_CHANGED_ID).post(settings);
    }
}