package demo.java.vm.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.text.InputType;
import android.widget.EditText;

import demo.java.vm.R;

/**
 * Created by Al Warren on 5/15/2018.
 */

public class TextInputDialog {
    private Context context;
    private String title;

    public TextInputDialog(Context context, String title) {
        if (!(context instanceof OnTextResult)) {
            try {
                throw(new Throwable(context.getString(R.string.text_input_dialog_error)));
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        this.context = context;
        this.title = title;

        if (title.isEmpty()) {
            context.getString(R.string.text_input_dialog_title);
        }
    }

    public TextInputDialog(Context context, int resource) {
        this(context, context.getString(resource));
    }

    public interface OnTextResult {
        void onTextDialogResult(String input);
    }

    public AlertDialog build() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        EditText input = new EditText(context);
        input.setInputType(InputType.TYPE_CLASS_TEXT);

        builder.setTitle(title)
                .setView(input)
                .setPositiveButton(R.string.ok, (dialog, which) ->
                        ((OnTextResult) context).onTextDialogResult(input.getText().toString()))
                .setNegativeButton(R.string.cancel, (dialog, which) -> dialog.cancel());

        return builder.create();
    }
}
