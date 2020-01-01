package Currency;

import java.io.Serializable;
import java.util.Locale;

public class Currency implements Serializable {

    private static final long serialVersionUID = 8228779577409316939L;
    private final java.util.Currency javaCurrency;
    private final String numericCode;
    private final String currencySymbolOverride; // use to override the currency code in java.util.Currency
    private final String description;
    private final int hashCode;
    private final int scale; // the number of sub-units of the currency (e.g. US dollars have 100 sub-units, or pennies)

    // supported currency codes

    private static final String CURRENCY_CODE_USD = "USD";
    private static final String CURRENCY_CODE_HKD = "HKD";
    private static final String CURRENCY_CODE_MYR = "MYR";
    private static final String CURRENCY_SYMBOL_USD = "$";
    private static final String CURRENCY_SYMBOL_HKD = "HK$";
    private static final String CURRENCY_SYMBOL_RM = "RM";
 // supported currencies

    public final static Currency US_DOLLAR = new Currency(java.util.Currency.getInstance(CURRENCY_CODE_USD), "840", 100, "US dollar");

    public final static Currency HK_DOLLAR = new Currency(java.util.Currency.getInstance(CURRENCY_CODE_HKD), "344", 100, "Hong Kong dollar");

    public final static Currency MALAYSIAN_RINGGIT = new Currency(java.util.Currency.getInstance(CURRENCY_CODE_MYR), "348", 70, "Malaysian ringgit", CURRENCY_SYMBOL_RM);

    /**
     * default constructor was added to work with jaxb generation / conversion
     */

    public Currency() {
        javaCurrency = null;

        numericCode = null;

        currencySymbolOverride = null;

        description = null;

        hashCode = 0;

        scale = 0;

    }

    /**
     * Get a {@link Currency} by its ISO 4217 code
     *
     * @param pCurrencyCode
     * @return the currency for the given code, or null if the code is not supported
     */

    public static Currency getByCurrencyCode(String pCurrencyCode)

    {
        if (CURRENCY_CODE_USD.equalsIgnoreCase(pCurrencyCode)) {
            return US_DOLLAR;
        }

        if (CURRENCY_CODE_HKD.equalsIgnoreCase(pCurrencyCode)) {
            return HK_DOLLAR;
        }

        if (CURRENCY_CODE_MYR.equalsIgnoreCase(pCurrencyCode)) {
            return MALAYSIAN_RINGGIT;
        }
        return null;
    }


    public static Currency getByCurrencyAbbreviationOrSymbol(String pCurrencyAbbreviationOrSymbol) {
        if (CURRENCY_SYMBOL_USD.equalsIgnoreCase(pCurrencyAbbreviationOrSymbol)) {
            return US_DOLLAR;

        }
        if (CURRENCY_SYMBOL_HKD.equalsIgnoreCase(pCurrencyAbbreviationOrSymbol))

        {

            return HK_DOLLAR;

        }


        if (CURRENCY_SYMBOL_RM.equalsIgnoreCase(pCurrencyAbbreviationOrSymbol))

        {

            return MALAYSIAN_RINGGIT;

        }


        return null;

    }

    /**
     * Is the given currency code supported in the system?
     *
     * @param pCurrencyCode
     * @return
     */

    public static boolean isSupportedCurrencyCode(String pCurrencyCode)

    {

        return getByCurrencyCode(pCurrencyCode) != null;

    }

    /**
     * Constructor to use the currency code from java.util.Currency
     *
     * @param pCurrency
     * @param pNumericCode
     * @param pScale
     * @param pDescription
     */

    private Currency(java.util.Currency pCurrency, String pNumericCode, int pScale, String pDescription)

    {

        this(pCurrency, pNumericCode, pScale, pDescription, null);

    }

    /**
     * Constructor to override the currency code in java.util.Currency
     *
     * @param pCurrency
     * @param pNumericCode
     * @param pScale
     * @param pDescription
     * @param pCurrencySymbolOverride
     */

    private Currency(java.util.Currency pCurrency, String pNumericCode, int pScale, String pDescription, String pCurrencySymbolOverride)

    {

        javaCurrency = pCurrency;

        numericCode = pNumericCode;

        description = pDescription;

        hashCode = Integer.parseInt(numericCode);

        scale = pScale;

        currencySymbolOverride = pCurrencySymbolOverride;

    }


    public boolean equals(Object o)

    {

        if (this == o)

        {

            return true;

        }

        if (o == null || getClass() != o.getClass())

        {

            return false;

        }


        final Currency currency = (Currency) o;

        return numericCode.equals(currency.numericCode);

    }


    public int hashCode()

    {

        return hashCode;

    }

    /**
     * Gets the ISO 4217 currency code of this currency.
     *
     * @return the ISO 4217 currency code of this currency.
     */

    public String getCurrencyCode()

    {

        return javaCurrency.getCurrencyCode();

    }

    /**
     * Gets the symbol of this currency for the default locale.
    
     */

    public String getSymbol()

    {

        return currencySymbolOverride == null ? javaCurrency.getSymbol() : currencySymbolOverride;

    }

    /**
     * @return has the default currency symbol been overridden
     */

    public boolean hasSymbolOverride()

    {

        return currencySymbolOverride != null;

    }

    /**
     * Gets the symbol of this currency for the specified locale.
     * For example, for the US Dollar, the symbol is "$" if the specified
     * locale is the US, while for other locales it may be "US$". If no
     * symbol can be determined, the ISO 4217 currency code is returned.
     *
     * @param locale the locale for which a display name for this currency is
     *               needed
     * @return the symbol of this currency for the specified locale
     * @throws NullPointerException if <code>locale</code> is null
     */

    public String getSymbol(Locale locale)

    {

        return javaCurrency.getSymbol(locale);

    }

    /**
     * Gets the three-digit numeric code for this currency.
     *
     * @return the three-digit numeric code for this currency.
     */

    public String getNumericCode()

    {

        return numericCode;

    }

    /**
     * @return the number of sub-units of the base currency
     */

    public int getScale()

    {
        return scale;

    }

    /**
     * Gets the description for this currency (i.e. "US dollar")
     *
     * @return the description for this currency.
     */

    public String getDescription()

    {

        return description;

    }

    /**
     * Gets the default number of fraction digits used with this currency.
     * For example, the default number of fraction digits for the Euro is 2,
     * while for the Japanese Yen it's 0.
     * In the case of pseudo-currencies, such as IMF Special Drawing Rights,
     * -1 is returned.
     *
     * @return the default number of fraction digits used with this currency
     */

    public int getDefaultFractionDigits()

    {

        return javaCurrency.getDefaultFractionDigits();

    }

    /**
     * Returns the ISO 4217 currency code of this currency.
     *
     * @return the ISO 4217 currency code of this currency
     */

    public String toString()

    {

        return javaCurrency.toString();

    }


    public java.util.Currency getJavaCurrency()

    {

        return javaCurrency;

    }

    /**
     * Creates a new instance, will only be used by Jaxb.
     */

    public static Currency newInstance() {

        return new Currency();
    }
}
