

AUI().use('aui-base', function(A) {

    Liferay.namespace('Chat');

    // If there is no chat bar do nothing
    if (!A.one('#chatBar')) {
        return;
    }
  
    // Import javascript resources
    var jsFolder = '/liferay-lims-portlet/js';
    var resources = [
        // Chat
        jsFolder + '/chat/Liferay.Chat.Container.BuddyList.js',
        jsFolder + '/chat/Liferay.Chat.Container.ConversationList.js',
        jsFolder + '/chat/Liferay.Chat.Container.ConversationSessions.js',
        jsFolder + '/chat/Liferay.Chat.Container.Settings.js',
        jsFolder + '/chat/Liferay.Chat.Container.Status.js',
        jsFolder + '/chat/Liferay.Chat.Menu.Conversation.js',
        jsFolder + '/chat/Liferay.Chat.Menu.AddToConversation.js',
        jsFolder + '/chat/Liferay.Chat.Menu.LeaveConversation.js',
        jsFolder + '/chat/Liferay.Chat.Menu.PeopleInConversation.js',
        jsFolder + '/chat/Liferay.Chat.Menu.Search.js',
        jsFolder + '/chat/Liferay.Chat.Manager.js',
        jsFolder + '/chat/Liferay.Chat.Globals.js',
        jsFolder + '/chat/Liferay.Chat.Error.js',
        jsFolder + '/chat/Liferay.Chat.Poller.js',
        jsFolder + '/chat/Liferay.Chat.Util.js',
        jsFolder + '/chat/Liferay.Chat.Panel.js',
        jsFolder + '/chat/Liferay.Chat.Conversation.js',
        jsFolder + '/chat/Liferay.Chat.Notification.js',      
    ];
    
    // Dynamic detection of jquery
      if (typeof jQuery !== 'undefined' || typeof $ !== 'undefined') {
        // jQuery is loaded            
        resources.push((jsFolder + '/lib/jquery.tokeninput.js'));  
    } else {
        // jQuery is not loaded        
        resources.push((jsFolder + '/lib/jquery.min.js'));        
        resources.push((jsFolder + '/lib/jquery.tokeninput.js'));                 
    }

    // Dynamic load of scripts
    A.Get.script(resources, {
        onSuccess: function() {
            // Init manager on startup
            Liferay.publish('chatPortletReady', {
                defaultFn: A.bind(Liferay.Chat.Manager.init, Liferay.Chat.Manager),
                fireOnce: true
            });

            // Dom ready startup
            A.on('domready', function() {
                Liferay.fire('chatPortletReady');
            });
        }
    });
});