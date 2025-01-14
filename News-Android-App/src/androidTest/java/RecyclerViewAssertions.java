import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by david on 18.09.15.
 */
public class RecyclerViewAssertions implements ViewAssertion {

    private int mExpectedPos;

    public RecyclerViewAssertions(int expectedPos) {
        this.mExpectedPos = expectedPos;
    }

    @Override
    public void check(View view, NoMatchingViewException e) {
        RecyclerView recyclerView = (RecyclerView) view;
        LinearLayoutManager layoutManager = ((LinearLayoutManager)recyclerView.getLayoutManager());
        int firstVisiblePosition = layoutManager.findFirstVisibleItemPosition();
        if(firstVisiblePosition == mExpectedPos)
            return;
        else
            throw new RuntimeException("Wrong position! Expected: " + mExpectedPos + " but was: " + firstVisiblePosition);
    }
}
