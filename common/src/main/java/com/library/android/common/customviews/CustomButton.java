package com.library.android.common.customviews;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.library.android.common.R;
import com.library.android.common.utils.TypefaceUtils;

public class CustomButton extends AppCompatTextView {

    /**
     * An int {@link android.graphics.Color} to set as for {@link android.widget.TextView#setTextColor(int)} with alpha color state list
     */
    private int btnTxtColor;
    private int btnTxtPressedColor;
    private boolean isAlphaPressedColor;
    private int btnTxtTypeface;

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.CustomButton, 0, 0);
        setCustomTypeface(typedArray); //Sets custom typeface
        setAlphaColorStates(typedArray); //Sets alpha color state list
    }

    private void setCustomTypeface(TypedArray typedArray) {
        int typeface = typedArray.getInteger(R.styleable.CustomButton_typeface, 0);
        setBtnTxtTypeface(typeface);
    }

    /**
     * Initializes our primary color customization
     * <p>
     * If {@link #isAlphaPressedColor} is true then our {@link CustomButton} will have color state list for different states
     * <p>
     * Being used in {@link #CustomButton(Context, AttributeSet)}
     *
     * @param typedArray A {@link TypedArray} from {@link #CustomButton(Context, AttributeSet)}
     * @since 1.0
     */
    private void setAlphaColorStates(TypedArray typedArray) {
        setBtnTxtColor(typedArray.getInteger(R.styleable.CustomButton_btnTxtColor, 0));
        setBtnTxtPressedColor(typedArray.getInteger(R.styleable.CustomButton_btnTxtPressedColor, 0));
        setAlphaPressedColor(typedArray.getBoolean(R.styleable.CustomButton_btnHasAlphaPressedColor, false));
        typedArray.recycle();
    }

    /**
     * Sets color state list (selector) programmatically
     * <p>
     * This works same as how selector drawable works.
     * <p>
     * Being used in {@link #setAlphaColorStates(TypedArray)}
     *
     * @param btnTxtColor An int color specified by custom property either in xml or by programmatically
     * @since 1.0
     */
    private void setColorStateList(int btnTxtColor) {
        int[][] states = new int[][]{
                new int[]{android.R.attr.state_pressed},
                new int[]{android.R.attr.state_focused},
                new int[]{android.R.attr.state_enabled}
        };

        int[] colors = new int[]{
                getBtnTxtPressedColor() == 0 ? getAlphaTxtColor(btnTxtColor) : getBtnTxtPressedColor(),
                getBtnTxtPressedColor() == 0 ? getAlphaTxtColor(btnTxtColor) : getBtnTxtPressedColor(),
                btnTxtColor
        };
        ColorStateList colorStateList = new ColorStateList(states, colors);
        setTextColor(colorStateList);
    }

    /**
     * Gives the value of {@link #btnTxtColor} programmatically
     *
     * @since 1.0
     */
    public int getBtnTxtColor() {
        return btnTxtColor;
    }

    /**
     * Gives the value of {@link #btnTxtPressedColor} programmatically
     *
     * @since 1.0
     */
    public int getBtnTxtPressedColor() {
        return btnTxtPressedColor;
    }

    /**
     * Gives color with alpha channel
     * <p>
     * Sets 50% opacity and hence 50% transparency as we are using static int value 128 for alpha.
     * We have set it so to keep the consistency throughout the app.
     * <p>
     * Being used in {@link #setColorStateList(int)}
     *
     * @param color A {@link #btnTxtColor} either set through xml or by programmatically
     * @return New value for {@link #btnTxtColor} having alpha channel added
     * @since 1.0
     */
    private int getAlphaTxtColor(int color) {
        return ColorUtils.setAlphaComponent(color, 128);
    }

    /**
     * Sets the value of {@link #btnTxtPressedColor} programmatically
     *
     * @param btnTxtPressedColor A {@link #btnTxtPressedColor} to be set for {@link CustomButton}
     * @since 1.0
     */
    public void setBtnTxtPressedColor(int btnTxtPressedColor) {
        this.btnTxtPressedColor = btnTxtPressedColor;
    }

    /**
     * Sets the value of {@link #btnTxtColor} programmatically
     *
     * @param btnTxtColor A {@link #btnTxtColor} to be set for {@link CustomButton}
     * @since 1.0
     */
    public void setBtnTxtColor(int btnTxtColor) {
        setTextColor(btnTxtColor);
        this.btnTxtColor = btnTxtColor;
        setColorStateList(getBtnTxtColor());
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr); //Do anything after super() here if we want to play with style (theme) as well
    }

    /**
     * Gives the value of {@link #isAlphaPressedColor}
     *
     * @since 1.0
     */
    public boolean isAlphaPressedColor() {
        return isAlphaPressedColor;
    }

    /**
     * Sets the value of {@link #isAlphaPressedColor} programmatically
     *
     * @param hasAlphaPressedColor A {@link #isAlphaPressedColor} to be set for {@link CustomButton}
     * @since 1.0
     */
    public void setAlphaPressedColor(boolean hasAlphaPressedColor) {
        this.isAlphaPressedColor = hasAlphaPressedColor;
    }

    /**
     * Gives the value of {@link #btnTxtTypeface} programmatically
     *
     * @since 1.0
     */
    public int getBtnTxtTypeface() {
        return btnTxtTypeface;
    }

    /**
     * Sets the value of {@link #btnTxtTypeface} programmatically
     *
     * @param btnTxtTypeface A {@link #btnTxtTypeface} to be set for {@link CustomButton}
     * @since 1.0
     */
    public void setBtnTxtTypeface(int btnTxtTypeface) {
        this.btnTxtTypeface = btnTxtTypeface;
        switch (btnTxtTypeface) {
            case TypefaceUtils.INT_CODE_REGULAR:
                setTypeface(TypefaceUtils.getInstance().getRegularTypeface(getContext()));
                break;

            case TypefaceUtils.INT_CODE_REGULAR_ITALIC:
                setTypeface(TypefaceUtils.getInstance().getRegularItalicTypeface(getContext()));
                break;

            case TypefaceUtils.INT_CODE_LIGHT:
                setTypeface(TypefaceUtils.getInstance().getLightTypeface(getContext()));
                break;

            case TypefaceUtils.INT_CODE_LIGHT_ITALIC:
                setTypeface(TypefaceUtils.getInstance().getLightItalicTypeface(getContext()));
                break;

            case TypefaceUtils.INT_CODE_BOLD:
                setTypeface(TypefaceUtils.getInstance().getBoldTypeface(getContext()));
                break;

            case TypefaceUtils.INT_CODE_BOLD_ITALIC:
                setTypeface(TypefaceUtils.getInstance().getBoldItalicTypeface(getContext()));
                break;

            case TypefaceUtils.INT_CODE_BOLD_HEAVY:
                setTypeface(TypefaceUtils.getInstance().getBoldHeavyTypeface(getContext()));
                break;

            default:
                setTypeface(TypefaceUtils.getInstance().getRegularTypeface(getContext()));
                break;
        }
    }
}