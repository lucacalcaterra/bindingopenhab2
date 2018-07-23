package org.openhab.binding.souliss.handler;

import org.eclipse.smarthome.core.library.types.DecimalType;
import org.eclipse.smarthome.core.thing.ChannelUID;
import org.eclipse.smarthome.core.thing.Thing;
import org.eclipse.smarthome.core.thing.ThingStatus;
import org.eclipse.smarthome.core.types.Command;
import org.eclipse.smarthome.core.types.PrimitiveType;
import org.openhab.binding.souliss.SoulissBindingConstants;
import org.openhab.binding.souliss.handler.SoulissGenericTypical.typicalCommonMethods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link SoulissTopicsHandler} is responsible for handling commands, which are
 * sent to one of the channels.
 *
 * @author Luca Remigio - Initial contribution
 */

public class SoulissTopicsHandler extends SoulissGenericActionMessage implements typicalCommonMethods {

    private Logger logger = LoggerFactory.getLogger(SoulissTopicsHandler.class);
    private DecimalType _setPointValue = DecimalType.ZERO;

    public SoulissTopicsHandler(Thing _thing) {
        super(_thing);
        thing = _thing;
    }

    @Override
    public void handleCommand(ChannelUID channelUID, Command command) {

    }

    @Override
    public void initialize() {
        // status online
        updateStatus(ThingStatus.ONLINE);
    }

    @Override
    public void setState(PrimitiveType _state) {
        this.setUpdateTimeNow();
        if (_state != null) {
            this.updateState(SoulissBindingConstants.LASTSTATUSSTORED_CHANNEL, this.getLastUpdateTime());
            this.updateState(SoulissBindingConstants.T5n_VALUE_CHANNEL, (DecimalType) _state);
        }
    }
}