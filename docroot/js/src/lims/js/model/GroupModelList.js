/**
 * Group Model List
 *
 * The class extends Y.ModelList and customizes it to hold a list of
 * GroupModel instances, and to provide some convenience methods for getting
 * information about the Group items in the list.
 *
 * Created by marcelmika on 4/12/14.
 */

Y.namespace('LIMS.Model');

Y.LIMS.Model.GroupModelList = Y.Base.create('groupModelList', Y.ModelList, [], {

    // This tells the list that it will hold instances of the GroupModel class.
    model: GroupModel,

    // This tells the list to use a localStorage sync provider (which we'll
    // create below) to load the list of todo items.
//    sync: LocalStorageSync('todo'),

    // Returns an array of all models in this list with the `done` attribute
    // set to `true`.
//    done: function () {
//        return this.filter(function (model) {
//            return model.get('type') === 'apple';
//        });
//    },

    // Returns an array of all models in this list with the `done` attribute
    // set to `false`.
//    remaining: function () {
//        return this.filter(function (model) {
//            return !model.get('done');
//        });
//    }

    // Custom sync layer.
    sync: function (action, options, callback) {
        var data,url, instance = this;

//        instance.callback = callback;

        switch (action) {
            case 'create':
                Y.log("create");
                data = this.toJSON();
                Y.log(data);
                return;
//                // Use the current timestamp as an id just to simplify the example. In a
//                // real sync layer, you'd want to generate an id that's more likely to
//                // be globally unique.
//                data.id = Y.Lang.now();
//
//                // Store the new record in localStorage, then call the callback.
//                localStorage.setItem(data.id, Y.JSON.stringify(data));
//                callback(null, data);
//                return;

            case 'read':
                Y.log("LIST: read");
                // TODO: Move away
                url = Y.one('#chatPortletURL').get('value');

                Y.io(url, {
                    method: "GET",
                    data: {
                        query: "Marcel"
                    },
                    on: {
                        success: function (id, o) {
                            var i, groups;
                            // Parse groups
                            groups = Y.JSON.parse(o.response);

                            // Add groups to list
                            for(i = 0; i < groups.length; i++) {
                                instance.add(groups[i]);
                            }
                        },
                        failure: function (x, o) {
                            console.log("groups not changed");
                            console.log(x);
                            console.log(o);
                        }
                    },
                    headers: {
                        'Content-Type': 'application/json'
                    }
                });

                return;

            // Look for an item in localStorage with this model's id.
//                data = localStorage.getItem(this.get('id'));
//
//                if (data) {
//                    callback(null, data);
//                } else {
//                    callback('Model not found.');
//                }
//
//                return;

            case 'update':
                Y.log("update");
                return;
//
//                data = this.toJSON();
//
//                // Update the record in localStorage, then call the callback.
//                localStorage.setItem(this.get('id'), Y.JSON.stringify(data));
//                callback(null, data);
//                return;

            case 'delete':
                Y.log("delete");
                return;
//                localStorage.removeItem(this.get('id'));
//                callback();
//                return;

            default:
                callback('Invalid action');
        }
    }

}, {});


//Y.LIMS.Model.GroupModelList = GroupModelList;