package net.sharksystem.creditmoney;

import net.sharksystem.SharkCertificateComponent;
import net.sharksystem.SharkException;
import net.sharksystem.SharkUnknownBehaviourException;
import net.sharksystem.asap.ASAPMessageReceivedListener;
import net.sharksystem.asap.ASAPMessages;
import net.sharksystem.asap.ASAPPeer;
import net.sharksystem.asap.persons.Person;

import java.io.IOException;
import java.util.Collection;

public class SharkCreditMoneyComponentImpl implements
        SharkCreditMoneyComponent, SharkCreditBondReceivedListener, ASAPMessageReceivedListener {
    private final SharkCertificateComponent certificateComponent;
    private ASAPPeer asapPeer;
    private SharkCreditBondReceivedListener sharkCreditBondReceivedListener;

    public SharkCreditMoneyComponentImpl(SharkCertificateComponent certificateComponent) {
        this.certificateComponent = certificateComponent;
    }

    @Override
    public void createBond(Person creditor, Person debtor, CharSequence unit, int amount) throws SharkCreditMoneyException {

    }

    @Override
    public Collection<SharkCreditBond> getBondsByCreditor(Person creditor) {
        return null;
    }

    @Override
    public Collection<SharkCreditBond> getBondsByDebtor(Person debtor) {
        return null;
    }

    @Override
    public Collection<SharkCreditBond> getBondsByCreditorAndDebtor(Person creditor, Person debtor) {
        return null;
    }

    @Override
    public void replaceDebtor(SharkCreditBond bond, Person newDebtor) throws SharkCreditMoneyException {

    }

    @Override
    public void replaceCreditor(SharkCreditBond bond, Person newDebtor) throws SharkCreditMoneyException {

    }

    @Override
    public void subscribeSharkCreditBondReceivedListener(SharkCreditBondReceivedListener listener) {
        // TODO just one listener. OK?
        this.sharkCreditBondReceivedListener = listener;
    }

    @Override
    public void annulBond(SharkCreditBond bond) throws SharkCreditMoneyException {

    }

    @Override
    public void onStart(ASAPPeer asapPeer) throws SharkException {
        this.asapPeer = asapPeer;
        this.asapPeer.addASAPMessageReceivedListener(
                SharkCreditMoneyComponent.SHARK_CREDIT_MONEY_FORMAT, this);
    }

    @Override
    public void setBehaviour(String s, boolean b) throws SharkUnknownBehaviourException {

    }


    @Override
    public void asapMessagesReceived(ASAPMessages asapMessages) throws IOException {
        SharkCreditBond bond = null;
        // TODO: deserialize Bond.

        this.sharkCreditBondReceivedListener.sharkCreditBondReceived(bond, asapMessages.getURI());
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                          act on received bonds                                       //
    //////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void sharkCreditBondReceived(SharkCreditBond bond, CharSequence uri) {
        switch(uri.toString()) {
            case SharkCreditMoneyComponent.SHARK_CREDIT_MONEY_ASKED_TO_SIGN_AS_CREDITOR_URI: /* TODO */ break;
            case SharkCreditMoneyComponent.SHARK_CREDIT_MONEY_ASKED_TO_SIGN_AS_DEBTOR_URI: /* TODO */ break;
            case SharkCreditMoneyComponent.SHARK_CREDIT_MONEY_SIGNED_BOND_URI: /* TODO */ break;
            case SharkCreditMoneyComponent.SHARK_CREDIT_MONEY_ANNUL_BOND_URI: /* TODO */ break;
            default: // unknown URI
        }
    }
}
