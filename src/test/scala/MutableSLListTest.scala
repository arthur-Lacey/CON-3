import org.scalatest._

class MutableSLListTest extends FlatSpec with Matchers {

  behavior of "A MutableSLList"

  it should "produce IndexOutOfBoundsException on apply at index < 0" in {
    var list = new MutableSLList[String]
    list += "test"
    intercept[IndexOutOfBoundsException] {
      list.apply(-1)
    }
    assert(list.length == 1)
  }

  it should "produce IndexOutOfBoundsException on apply at index > length" in {
    var list = new MutableSLList[String]
    list += "test"
    intercept[IndexOutOfBoundsException] {
      list.apply(1)
    }
    assert(list.length == 1)
  }

  it should "produce IndexOutOfBoundsException on insertAll at index < 0" in {
    var list = new MutableSLList[String]
    list += "test"
    intercept[IndexOutOfBoundsException] {
      list.insertAll(-1, List("one", "two", "three"))
    }
    assert(list.length == 1)
  }

  it should "produce IndexOutOfBoundsException on insertAll at index > length + 1" in {
    var list = new MutableSLList[String]
    list += "test"
    intercept[IndexOutOfBoundsException] {
      list.insertAll(2, List("one", "two", "three"))
    }
    assert(list.length == 1)
  }

  it should "produce IndexOutOfBoundsException on remove at index < 0" in {
    var list = new MutableSLList[String]
    list += "test"
    intercept[IndexOutOfBoundsException] {
      list.remove(-1)
    }
    assert(list.length == 1)
  }

  it should "produce IndexOutOfBoundsException on remove at index > length" in {
    var list = new MutableSLList[String]
    list += "test"
    intercept[IndexOutOfBoundsException] {
      list.remove(1)
    }
    assert(list.length == 1)
  }

  it should "contain one less element on remove" in {
    var list = new MutableSLList[String]
    list += "one"
    list += "two"
    assert(list.length == 2)
    list.remove(0)
    assert(list.length == 1)
  }

  it should "have length 0 when removing the last element" in {
    var list = new MutableSLList[String]
    list += "one"
    assert(list.length == 1)
    list.remove(0)
    assert(list.length == 0)
  }

  it should "produce IndexOutOfBoundsException on update at index < 0" in {
    var list = new MutableSLList[String]
    list += "test"
    intercept[IndexOutOfBoundsException] {
      list.update(-1, "update")
    }
    assert(list.length == 1)
  }

  it should "produce IndexOutOfBoundsException on update at index > length" in {
    var list = new MutableSLList[String]
    list += "test"
    intercept[IndexOutOfBoundsException] {
      list.update(1, "update")
    }
    assert(list.length == 1)
  }

  it should "change the element at index n to the new element value" in {
    var list = new MutableSLList[String]
    list += "test"
    list.update(0, "update")
    assert(list.length == 1)
    assert(list(0) == "update")
  }

  it should "block the calling thread on remove if empty" in {
    fail()
  }

  it should "unblock threads waiting to remove items when item added by +=" in {
    fail()
  }

  it should "unblock threads waiting to remove items when item added by +=:" in {
    fail()
  }
  it should "unblock threads waiting to remove items when item added by insertAll" in {
    fail()
  }
}